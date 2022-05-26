package com.mangotrade.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/tmp/user_data.properties",
        "system:properties",
        "classpath:config/user_data.properties"
})
public interface UserDataConfig extends Config {

    @Key("userLogin")
    String userLogin();

    @Key("userPassword")
    String userPassword();

    @Key("firstName")
    String firstName();

    @Key("lastName")
    String lastName();

    @Key("userCountry")
    int userCountry();
}
