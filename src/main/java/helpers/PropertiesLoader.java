package helpers;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties props;

    static {
        props = new Properties();
        String test;
        try (FileInputStream input = new FileInputStream("config/application.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    public static String readPropertyFile(String propertyName) {
        return props.getProperty(propertyName);
    }
}
