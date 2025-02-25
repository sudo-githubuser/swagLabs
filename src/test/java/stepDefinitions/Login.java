package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    }

    @When("Enters username {string}")
    public void entersUsername(String uName) {
        loginPage.enterUserName(uName);
    }

    @Then("User is in {string} homepage")
    public void userIsInHomepage(String s) {
        if(loginPage.validateLoginPage(s)){
            System.out.println("User is in Swag Labs login page");
        } else { System.out.println("User is not in Swag Labs login page"); }
    }

    @Then("User logged in successfully")
    public void userLoggedInSuccessfully() {
        loginPage.login();
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String eMessage) {
        if(loginPage.errorMessage().contains(eMessage)){
            System.out.println("Error message " + loginPage.errorMessage() + " is displayed");
        } else {
            System.out.println(loginPage.errorMessage());
        }
    }

    @And("login is unsuccessful")
    public void loginIsUnsuccessful() {
    }
}
