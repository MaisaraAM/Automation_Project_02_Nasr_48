package org.example.stepDefs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configurations {
    public static String getConfig(String key) throws IOException {
        String value;
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");

        prop.load(fis);
        value = prop.getProperty(key);
        fis.close();

        return value;
    }

    public static void setFake(String key, String value) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("credentials.properties");

        prop.load(fis);
        prop.setProperty(key, value);
        fis.close();

        FileOutputStream fos = new FileOutputStream("credentials.properties");

        prop.store(fos, "");
    }

    public static String getFake(String key) throws IOException {
        String value;
        Properties prop = new Properties();
        FileInputStream fis =  new FileInputStream("credentials.properties");

        prop.load(fis);
        value = prop.getProperty(key);
        fis.close();

        return value;
    }
}