package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import utilities.ReadConfig;

public class BaseClass {
    ReadConfig rc = new ReadConfig();
    String url = rc.getURL();
    String browser = rc.getBrowser();
    public String username = rc.getUserName();
    public String password = rc.getPassword();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() {
        logger = Logger.getLogger("Automation");
        String parameterBrowser = System.getProperty(browser) != null ? System.getProperty(browser) : browser;
//			PropertyConfigurator.configure("log4j.properties");
        switch (parameterBrowser.toLowerCase()) {
            case "chrome": {
                driver = new ChromeDriver();
                logger.info("Initializing Chrome Browser");
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                logger.info("Initializing Edge Browser");
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                logger.info("Initializing Firefox Browser");
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                logger.info("Initializing Safari Browser");
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value of the browser in config file.: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    @AfterTest
    public void tearDown() {
        logger.info("Closing the browser");
        // TODO Auto-generated method stub
        driver.quit();
    }

    public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
    }

}
