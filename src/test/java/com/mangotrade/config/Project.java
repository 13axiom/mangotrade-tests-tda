package com.mangotrade.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    public static UserDataConfig userData = ConfigFactory.create(UserDataConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
