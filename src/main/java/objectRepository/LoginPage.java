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

    @FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']/h3")
    private WebElement errorMsg;

    public void launchURL(){
        driver.navigate().to(FileReaderManager.getConfigReader().getApplicationURL());
    }

    public boolean validateLoginPage(String s){
        loginPage.getText().equalsIgnoreCase(s);
        return true;
    }

    public void enterUserName(String uName){userName.sendKeys(uName);}
    public void enterPassword(String pwd){password.sendKeys(pwd);}
    public void login(){loginBtn.click();}
    public String errorMessage(){
        return errorMsg.getText();
    }

}
