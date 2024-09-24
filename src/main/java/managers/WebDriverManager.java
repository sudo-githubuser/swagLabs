package managers;

import enums.DriverType;
import io.github.bonigarcia.wdm.managers.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager(){
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver(){
        if(driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case FIREFOX: driver = new FirefoxDriver();
            break;
            case CHROME:
            /* Added the below lines of code for Github action execution */
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--proxy-server='direct://'");
            options.addArguments("--proxy-bypass-list=*");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-gpu");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--no-first-run");
            options.addArguments("--no-default-browser-check");
            options.addArguments("--test-type");

            driver = new ChromeDriver(options);
            break;
            case INTERNETEXPLORER: driver = new InternetExplorerDriver();
            break;
        }

        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitWait());
        return driver;
    }
    public void closeDriver() {driver.close();}
    public void quitDriver() {driver.quit();}
}
