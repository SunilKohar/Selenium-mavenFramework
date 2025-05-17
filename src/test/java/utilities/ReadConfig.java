package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    FileInputStream fis;
    String path = System.getProperty("user.dir")+"/configurations/application.properties";

    public ReadConfig()  {

        properties = new Properties();
        try {
            fis = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public String getURL() {
        String urlValue= properties.getProperty("url");
        if(urlValue !=null) {
            return urlValue;
        }
        else {
            throw new RuntimeException("URL value is not specified in the config file. Please specify it.");
        }
    }
    public String getBrowser() {
        String browserValue= properties.getProperty("browser");
        if(browserValue !=null) {
            return browserValue;
        }
        else {
            throw new RuntimeException("browser value is not specified in the config file. Please specify it.");
        }
    }
    public String getUserName() {
        String usernameValue= properties.getProperty("userName");
        if(usernameValue !=null) {
            return usernameValue;
        }
        else {
            throw new RuntimeException("username is not specified in the config file. Please specify it.");
        }
    }
    public String getPassword() {
        String passwordValue= properties.getProperty("password");
        if(passwordValue !=null) {
            return passwordValue;
        }
        else {
            throw new RuntimeException("password is not specified in the config file. Please specify it.");
        }
    }
}
