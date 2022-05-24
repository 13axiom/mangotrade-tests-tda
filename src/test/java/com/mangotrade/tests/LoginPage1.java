package com.mangotrade.tests;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import models.LoginData;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.mangotrade.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;


public class LoginPage1 extends TestBaseUI {

   /* @Test
    @Feature("Login page design")
    @Description("Login test 5")
    @DisplayName("Login form has form header 'Log In'")
    void checkLoginFormHeader() {
        step("Open url '${url}}en/login'", () -> {
            open("/en/login");
        });
        sleep(5000);//todo this line for check in remote browser, can be deleted
        step("Check login header form", () -> {
            step("Check form header -> should be 'Log In'", () -> {
                $(".css-1ffs9d1.e131aulr0").shouldHave(exactText("Log In"));
            });
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Login test 1")
    @DisplayName("Success login to account")
    void successLogin() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
            open("/en/login");
        });

        step("Set email 'mnn'", () -> {
            $("[name=identifier]").setValue("mnenie@bk.ru");
        });

        step("Set password 'Test123'", () -> {
            $("[name=password]").setValue("Test1234");
        });

        step("Click button \"Log in\"", () -> {
            $("[data-test-id=login-submit-button]").click();
            sleep(10000);
        });

        step("Redirect to 'https://trade.mangotrade.com/traderoom'", () -> {
            String currURL = DriverUtils.getCurrUrl();
            assertEquals("https://trade.mangotrade.com/traderoom", currURL);
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Login test 2")
    @DisplayName("Failed login with null data")
    void failedLoginBothFieldsNull() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
            open("/en/login");
        });

        step("Click button \"Log in\"", () -> {
            $("[data-test-id=login-submit-button]").click();
        });

        step("Expected Results", () -> {
            step("Error message below field 'Email'", () -> {
                $("[data-test-id=login-email-input]").$(".iqInput__error.active").shouldHave(text("Fill out the field"));
            });
            step("Error message below field 'Password'", () -> {
                $("[data-test-id=login-password-input]").$(".iqInput__error.active").shouldHave(text("Fill out the field"));
            });
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Login test 3")
    @DisplayName("Failed login without password")
    void failedLoginNullPassword() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
            open("/en/login");
        });

        step("Set email 'mnn'", () -> {
            $("[name=identifier]").setValue("mnenie@bk.ru");
        });

        step("Click button \"Log in\"", () -> {
            $("[data-test-id=login-submit-button]").click();
        });

        step("Expected Results", () -> {
            step("Error message below field 'Password'", () -> {
                $("[data-test-id=login-password-input]").$(".iqInput__error.active").shouldHave(text("Fill out the field"));
            });
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Login test 4")
    @DisplayName("Failed login without Email")
    void failedLoginNullEmail() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
            open("/en/login");
        });

        step("Set password 'Test123'", () -> {
            $("[name=password]").setValue("Test1234");
        });

        step("Click button \"Log in\"", () -> {
            $("[data-test-id=login-submit-button]").click();
        });

        step("Expected Results", () -> {
            step("Error message below field 'Email'", () -> {
                $("[data-test-id=login-email-input]").$(".iqInput__error.active").shouldHave(text("Fill out the field"));
            });
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Simple test 2")
    @DisplayName("'Log in' page should have warning about risks")
    void loginPageShouldHaveRiskWarning() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("/en/login"));

        step("'Log in' page should have warning about risks", () -> {
            $("[data-test-id=auth-warning-block]").scrollIntoView(true).
                    shouldHave(exactText("Risk Warning: All trading involves risk. Only risk capital you're prepared to lose."));
        });
    }

    @Test
    @Feature("Service test")
    @Description("Simple test 1")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("/en/login"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Simple test 3")
    @DisplayName("Successful redirect to registration form")
    void successRedirectToRegistrationForm() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("/en/login"));

        step("'Click button 'Sing Up'", () -> {
            $("[data-test-id=header-register-button]").click();
        });


        step("Check redirect to registration form", () -> {
            step("Check link", () -> {
                sleep(10000);
                String currURL = DriverUtils.getCurrUrl();
                assertEquals("https://trade.mangotrade.com/en/register", currURL);
            });

            step("Check form header -> should be 'Sing Up'", () -> {
                $(".RegisterFormContainer").$("h1").shouldHave(exactText("Sign Up"));
            });
        });
    }*/

    @Test
    @Tags({@Tag("positive"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Success sing in to account")
    @Description("Rest API test #1")
    void successSingIn() {
       /* LoginData data = new LoginData();
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
                .body("ssid", Matchers.is(notNullValue()));*/

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