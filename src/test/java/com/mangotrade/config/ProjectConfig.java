package com.mangotrade.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/tmp/remote.properties",
        "system:properties",
        "classpath:config/${url}.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @Key("browserMobileView")
    @DefaultValue("")
    String browserMobileView();

    @Key("remoteDriverUrl")
    @DefaultValue("")
    String remoteDriverUrl();

    @Key("videoStorage")
    @DefaultValue("")
    String videoStorage();

    @Key("baseurl")
    @DefaultValue("https://trade.mangotrade.com/")
    String webUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browser.size")
    @DefaultValue("3840x2160")
    String browserSize();

    @Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("restbaseurl")
    @DefaultValue("https://auth.trade.mangotrade.com")
    String restUrl();

}
