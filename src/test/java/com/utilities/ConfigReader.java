package com.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.utilities.*;

public class ConfigReader {
	private static Properties properties;
    private final static String propertyFilePath = "./src/test/resource/Config/config.properties";    
    
    
    public static Properties readConfig() throws Throwable {
        InputStream fis;
        fis = ConfigReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
        properties = new Properties();
        if (fis == null) {
            throw new FileNotFoundException("Property file '" + propertyFilePath + "' not found in the classpath");
        }
        try {
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    } 
   

}
