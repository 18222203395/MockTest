package com.alen;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by y64195 on 2017/9/30.
 */
public class Configuration {

    private static Boolean enabled;

    public static boolean isEnabled(){
        if(enabled == null){
            loadProperties();
        }
        return enabled;
    }

    private static void loadProperties(){
        Properties properties = readProperties();
        enabled = "true".equals(properties.getProperty("enabled"));
    }

    private static Properties readProperties(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("some properties"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }
}
