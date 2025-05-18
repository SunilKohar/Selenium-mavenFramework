package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewOpportunityPage {
    WebDriver driver;
    public NewOpportunityPage(WebDriver rdriver){
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@aria-label='App']")
    WebElement btnApps;

    @FindBy(how = How.ID, using = "07pdL000001rxnrQAA")
    WebElement lnkCRMClassic;

    @FindBy(how = How.XPATH, using = "//a[@title='Opportunities']")
    WebElement btnOpportunities;

    @FindBy(how = How.XPATH, using = "//a[@title='New']")
    WebElement btnNew;

    @FindBy(how = How.NAME, using = "Amount")
    WebElement txtAmount;

    @FindBy(how = How.NAME, using = "CloseDate")
    WebElement dateCloseDate;

    @FindBy(how = How.NAME, using = "Name")
    WebElement txtopportunityName;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Stage']")
    WebElement drpStage;

    @FindBy(how = How.NAME, using = "SaveEdit")
    WebElement btnSave;

    @FindBy(how = How.NAME, using = "primaryField")
    WebElement lbloppName;

    public void appButton(){
        btnApps.click();
    }
    public void newButton() throws InterruptedException {
        lnkCRMClassic.click();
        Thread.sleep(2000);
        btnOpportunities.click();
        btnNew.click();
    }
    public void details( String name){
        txtAmount.sendKeys("30000");
        dateCloseDate.sendKeys("31/12/2026");
        txtopportunityName.sendKeys(name);
        Select select= new Select(drpStage);
        select.selectByIndex(2);
        btnSave.click();
    }

}
