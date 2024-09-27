package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    @Given("^User enters \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void userEntersInThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @Then("^User is in \"([^\"]*)\" homepage$")
    public void userIsInHomepage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("^Enters \"([^\"]*)\"$")
    public void enters(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @When("^stepDefinitions.Login$")
    public void login() {
    }

    @Then("^User logged in successfully$")
    public void userLoggedInSuccessfully() {
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void messageIsDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @And("^login is unsuccessful$")
    public void loginIsUnsuccessful() {
    }
}
