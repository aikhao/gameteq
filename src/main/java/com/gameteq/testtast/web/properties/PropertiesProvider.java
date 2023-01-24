package com.gameteq.testtast.web.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesProvider {

    private static PropertiesProvider instance;
    private Properties properties;

    public PropertiesProvider() {
        try {
            properties = new Properties();

            setProperties(System.getProperties());

            final File local_prop_file = new File("local.properties");

            if (local_prop_file.exists()) {
                Properties prop_local = new Properties();
                prop_local.load(new FileInputStream(local_prop_file));
                setProperties(prop_local);
            } else {
                throw new FileNotFoundException("File " + local_prop_file + " not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PropertiesProvider getInstance() {
        if (instance == null) {
            instance = new PropertiesProvider();
        }
        return instance;
    }

    private static Properties getProperties() {
        return getInstance().properties;
    }

    private void setProperties(Properties properties_new) {
        properties_new.forEach(
            (Object key, Object value) -> {
                if (!properties.containsKey(key)) {
                    properties.setProperty(key.toString(), value.toString());
                }
            }
        );
    }

    public static String getProperty(String propertyName){
        if (getProperties().containsKey(propertyName)) {
            return getProperties().getProperty(propertyName);
        } else {
            throw new IllegalArgumentException(String.format("Cannot find property %s", propertyName));
        }
    }

    public static void setProperty(String key, String value){
        getProperties().setProperty(key, value);
    }

}
