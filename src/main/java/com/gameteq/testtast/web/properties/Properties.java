package com.gameteq.testtast.web.properties;

public class Properties extends PropertiesProvider {

    // parameters
    public static int timeoutWaitStep = Integer.parseInt(getProperty("timeout.wait.step"));
    public static int timeoutLongWaitStep = Integer.parseInt(getProperty("timeout.wait.step.long"));

    public static String urlFront = getProperty("instance.url");
}
