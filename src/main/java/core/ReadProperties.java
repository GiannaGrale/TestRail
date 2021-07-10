package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() { return properties.getProperty("url");}
    public String getBrowser() { return properties.getProperty("browser");}
    public String getUsername() { return properties.getProperty("usernamePositive");}
    public String getUsernameWrong() { return properties.getProperty("usernameWrong");}
    public  String getUsernameEmpty (){return properties.getProperty("usernameEmpty");}

    public String getPassword() { return properties.getProperty("passwordPositive");}
    public String getPasswordWrong() { return properties.getProperty("passwordWrong");}
    public  String getPasswordEmpty (){return properties.getProperty("passwordEmpty");}

    public int getTimeout(){ return Integer.parseInt(properties.getProperty("timeout"));}
    public boolean getHeadless(){ return Boolean.parseBoolean(properties.getProperty("headless"));}

}