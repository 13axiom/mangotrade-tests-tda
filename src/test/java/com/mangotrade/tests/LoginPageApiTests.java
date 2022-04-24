package com.mangotrade.tests;

import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import models.LoginData;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.mangotrade.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageApiTests extends TestBase {

    @Test
    @Tag("api_test")
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login page api-functional tests")
    @Description("Rest API test 1")
    @DisplayName("Success login to account (API test)")
    void successLoginViaRestAPI() {
        open();//todo костыль, потому что в beforeall вызывается вебдрайвер и он ожидает урл
        LoginData data = new LoginData();
        data.setIdentifier("mnenie@bk.ru");
        data.setPassword("Test1234");

        given()
                .filter(withCustomTemplates())
                .contentType("application/json")
                .cookie("platform=90; " +
                        "lang=en_US; " +
                        "ssid=054fa7be0f836899ee76da4c7aca8bb8")
                .header("Connection", "keep-alive")
                .body(data)
                .log().uri()
                .log().body()
                .when()
                .post("/api/v2/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("code", is("success"))
                .body("ssid", Matchers.is(notNullValue()));

        /*
        curl --location --request POST 'https://auth.trade.mangotrade.com/api/v2/login' \
--header 'Content-Type: application/json' \
--header 'Connection: keep-alive' \
--header 'Cookie: device_id=3YGp1PaZcCkiO7zazNa2; web_rules=; init_url=https://trade.mangotrade.com/en/login; platform=90; landing=trade.mangotrade.com; lang=en_US; pll_language=en; _gcl_au=1.1.1465944008.1650311546; _ga_BH1SENMS6L=GS1.1.1650311546.1.1.1650311693.0; _ga=GA1.2.2130918845.1650311546; _ym_uid=1650311547675546183; _ym_d=1650311547; _ym_visorc=b; _ym_isad=2; _fbp=fb.1.1650311547145.1764646748; afUserId=c7bb0519-2087-48b0-b307-4b61610965cb-p; AF_SYNC=1650311547841; _gid=GA1.2.1131175257.1650311548; platform_version=2446.5.0946.release; referrer=https://trade.mangotrade.com/traderoom; ssid=054fa7be0f836899ee76da4c7aca8bb8' \
--data-raw '{"identifier":"mnenie@bk.ru","password":"Test1234"}'
        */
    }

    @Test
    @Tag("api_test")
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login page api-functional tests")
    @Description("Rest API test 2")
    @DisplayName("Success login to account WithoutCustomAllureTemplate (API test)")
    void DublicatedSuccessLoginViaRestAPIWithoutCustomAllureTemplate() {
        open();//todo костыль, потому что в beforeall вызывается вебдрайвер и он ожидает урл
        LoginData data = new LoginData();
        data.setIdentifier("mnenie@bk.ru");
        data.setPassword("Test1234");

        given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .cookie("platform=90; " +
                        "lang=en_US; " +
                        "ssid=054fa7be0f836899ee76da4c7aca8bb8")
                .header("Connection", "keep-alive")
                .body(data)
                .log().uri()
                .log().body()
                .when()
                .post("/api/v2/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("code", is("success"))
                .body("ssid", Matchers.is(notNullValue()));

        /*
        curl --location --request POST 'https://auth.trade.mangotrade.com/api/v2/login' \
--header 'Content-Type: application/json' \
--header 'Connection: keep-alive' \
--header 'Cookie: device_id=3YGp1PaZcCkiO7zazNa2; web_rules=; init_url=https://trade.mangotrade.com/en/login; platform=90; landing=trade.mangotrade.com; lang=en_US; pll_language=en; _gcl_au=1.1.1465944008.1650311546; _ga_BH1SENMS6L=GS1.1.1650311546.1.1.1650311693.0; _ga=GA1.2.2130918845.1650311546; _ym_uid=1650311547675546183; _ym_d=1650311547; _ym_visorc=b; _ym_isad=2; _fbp=fb.1.1650311547145.1764646748; afUserId=c7bb0519-2087-48b0-b307-4b61610965cb-p; AF_SYNC=1650311547841; _gid=GA1.2.1131175257.1650311548; platform_version=2446.5.0946.release; referrer=https://trade.mangotrade.com/traderoom; ssid=054fa7be0f836899ee76da4c7aca8bb8' \
--data-raw '{"identifier":"mnenie@bk.ru","password":"Test1234"}'
        */
    }

    @Test
    @Tag("api_test")
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Login page api-functional tests")
    @Description("Rest API test 3")
    @DisplayName("Failed login without password (API test)")
    void failedLoginNullPasswordViaRestAPI() {
        open();//todo костыль, потому что в beforeall вызывается вебдрайвер и он ожидает урл
        LoginData data = new LoginData();
        data.setIdentifier("mnenie@bk.ru");

        given()
                .filter(withCustomTemplates())
                .contentType("application/json")
                .cookie("platform=90; " +
                        "lang=en_US; " +
                        "ssid=054fa7be0f836899ee76da4c7aca8bb8")
                .header("Connection", "keep-alive")
                .body(data)
                .log().uri()
                .log().body()
                .when()
                .post("/api/v2/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(401)
                .body("code", is("invalid_credentials"))
                .body("message", containsString("entered the wrong credentials"));
    }

}