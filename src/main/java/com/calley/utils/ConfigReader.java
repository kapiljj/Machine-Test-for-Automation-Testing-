package com.calley.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String PROPERTIES_FILE_PATH = "src/main/java/com/calley/config/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in config.properties file");
        }
        return value;
    }
} 