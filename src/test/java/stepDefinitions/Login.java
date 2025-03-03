package stepDefinitions;

import com.aventstack.extentreports.Status;
import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.ExtentReportManager;
import objectRepository.LoginPage;

public class Login {

    TestContext testContext;
    LoginPage loginPage;

    public Login (TestContext context){
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }
    @Given("User lands on login page")
    public void userLandsOnLoginPage() {
        loginPage.launchURL();
        ExtentReportManager.getTest().log(Status.INFO, "**Step:** User is on login page");
    }

//    @Then("User is in {String} homepage")
//    public void userIsInHomepage(String s){
//        if(loginPage.validateLoginPage(s)){
//            System.out.println("User is in Swag Labs login page");
//        } else { System.out.println("User is not in Swag Labs login page"); }
//    }

    @When("Enters password {string}")
    public void entersPassword(String pwd) {
        loginPage.enterPassword(pwd);
        ExtentReportManager.getTest().log(Status.INFO, "**Step:** Enters password: *****");
    }

    @When("Enters username {string}")
    public void entersUsername(String uName) {
        loginPage.enterUserName(uName);
        ExtentReportManager.getTest().log(Status.INFO, "**Step:** Enters username \"" + uName + "\"");
    }

    @Then("User is in {string} homepage")
    public void userIsInHomepage(String s) {
        if(loginPage.validateLoginPage(s)){
            System.out.println("User is in Swag Labs login page");
            ExtentReportManager.getTest().log(Status.INFO, "**Step:** User is on homepage \"" + s + "\"");
        } else { System.out.println("User is not in Swag Labs login page"); }
    }

    @Then("User logged in successfully")
    public void userLoggedInSuccessfully() {
        loginPage.login();
        ExtentReportManager.getTest().log(Status.INFO, "**Step:** User logged in successfully");
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String eMessage) {
        if(loginPage.errorMessage().contains(eMessage)){
            System.out.println("Error message " + loginPage.errorMessage() + " is displayed");
            ExtentReportManager.getTest().log(Status.INFO, "**Step:** Error message \"" + eMessage + "is displayed" + "\"");
        } else {
            System.out.println(loginPage.errorMessage());
        }
    }

    @And("login is unsuccessful")
    public void loginIsUnsuccessful() {
        ExtentReportManager.getTest().log(Status.INFO, "**Step:** Login is unsuccessful");
    }
}
