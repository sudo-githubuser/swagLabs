package objectRepository;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    WebDriver driver;
    ConfigFileReader configFileReader;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    private WebElement loginPage;

    @FindBy(how = How.XPATH, using = "//input[@name='user-name']")
    private WebElement userName;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@name='login-button']")
    private WebElement loginBtn;

    public void launchURL(){
        driver.navigate().to(FileReaderManager.getConfigReader().getApplicationURL());
    }

    public void validateLoginPage(String s){
        loginPage.getText().equalsIgnoreCase(s);
    }

    public void enterUserName(String uName){userName.sendKeys(uName);}
    public void enterPassword(String pwd){password.sendKeys(pwd);}
    public void login(){loginBtn.click();}

}
