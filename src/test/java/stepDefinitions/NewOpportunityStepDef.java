package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BaseClass;
import pages.NewOpportunityPage;

public class NewOpportunityStepDef extends BaseClass {
    NewOpportunityPage nop = new NewOpportunityPage(driver);

    @Given("^I click on the App button$")
    public void appButtonClick(){
        nop.appButton();
    }
    @When("^I click on the New button$")
    public void newButtonClick() throws InterruptedException {
        nop.newButton();
    }

    @And("^I Enter the details$")
    public void enterDetails(){
        nop.details(oppName);
    }
    @Then("^I see that the details are saved$")
    public void verifyOppName(){

        Assert.assertEquals(driver.findElement(By.name("primaryField")).getText(), oppName,"The opportunity names are different so test case failed.");
    }
}
