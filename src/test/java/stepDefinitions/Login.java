public class Login {
    @io.cucumber.java.en.Given("^User enters \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void userEntersInThe(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.Then("^User is in \"([^\"]*)\" homepage$")
    public void userIsInHomepage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.When("^Enters \"([^\"]*)\"$")
    public void enters(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.When("^Login$")
    public void login() {
    }

    @io.cucumber.java.en.Then("^User logged in successfully$")
    public void userLoggedInSuccessfully() {
    }

    @io.cucumber.java.en.Then("^\"([^\"]*)\" message is displayed$")
    public void messageIsDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
    }

    @io.cucumber.java.en.And("^login is unsuccessful$")
    public void loginIsUnsuccessful() {
    }
}
