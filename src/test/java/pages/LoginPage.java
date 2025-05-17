package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
    WebDriver driver;
    public LoginPage(WebDriver rdriver){
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }


    @FindBy(how = How.NAME, using="username")
    WebElement txtUserName;

    @FindBy(how= How.ID, using = "password")
    WebElement txtpassword;

    @FindBy(how= How.NAME, using = "Login")
    WebElement btnLogin;

    @FindBy(how= How.NAME, using = "rememberUn")
    WebElement chkRememberMe;

    @FindBy(how= How.ID, using = "forgot_password_link")
    WebElement lnkForgotPwd;

    @FindBy(how = How.ID, using = "mydomainLink")
    WebElement lnkMyDomainName;

    @FindBy(how = How.ID, using = "gidr-email-log-in-button")
    WebElement lnkEmailLogin;

    public void login(String username, String password){
        txtUserName.clear();
        txtpassword.clear();
        txtUserName.sendKeys(username);
        txtpassword.sendKeys(password);
        btnLogin.click();
    }
}
