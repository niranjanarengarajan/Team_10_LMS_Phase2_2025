package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.utilities.*;

public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String PROPERTY_FILE_PATH = "./src/test/resources/Config/Config.properties";
    
    
    static {
        try (InputStream inputStream = new FileInputStream(PROPERTY_FILE_PATH)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    public static String getUrl() {
        return properties.getProperty("Url");
    }
}