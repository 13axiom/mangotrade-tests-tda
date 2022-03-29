package com.mangotrade.config.exampleforuiplusapi;

import org.aeonbits.owner.ConfigFactory;

public class App {
    public static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
}
