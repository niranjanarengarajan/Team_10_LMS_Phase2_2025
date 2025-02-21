package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.utilities.*;



public class ConfigReader {
public static Properties properties;
	
	public  ConfigReader() {
		File src = new File("./src/test/resources/Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

    // Browser Type
    public String browserType() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException("Browser Not Specified in Config.Properties file");
        }
    }

    // LMS Portal URL
    public String getLmsPortalUrl() {
        String url = properties.getProperty("lmsbaseurl");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("lmsbaseurl Not Specified in Config.Properties file");
        }
    }
}
