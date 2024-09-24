package dataProvider;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/main/resources/configs/configuration.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuartion.properties file");
    }

    public Duration getImplicitWait(){
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null){
            try{
                return Duration.ofSeconds((int)Long.parseLong(implicitlyWait));
            } catch (NumberFormatException e){
                throw new RuntimeException("Not able to parse value: " + implicitlyWait + " in to long");
            }
        }
        return Duration.ofSeconds(30);
    }

    public String getApplicationURL(){
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("Application URL not specified in the Configuration.properties file for the key:url");
    }

    public DriverType getBrowser(){
        String browserName = properties.getProperty("browser");
        if(browserName != null || browserName.equals("chrome")) return DriverType.CHROME;
        else if (browserName.equals("firefox")) return DriverType.FIREFOX;
        else if (browserName.equals("internet explorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser name key value in configuration.properties is not matched: " + browserName);
    }

}
