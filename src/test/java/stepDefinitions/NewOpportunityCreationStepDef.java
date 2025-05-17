package stepDefinitions;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.BaseClass;
import pages.LoginPage;

public class NewOpportunityCreationStepDef extends BaseClass {

    @Given ("^I am on the login page$")
    public void launchBrowser(){
        setup();
    }

    @When("^I enter the username and password$")
        public void login() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login(username,password);
        Thread.sleep(8000);

        }
    @Then("^I am logged in successfully$")
    public void loginValidation(){
        Assert.assertEquals(driver.getTitle(), "Home | Salesforce", "The title does not match the actual. So login failed.");
    }
}
