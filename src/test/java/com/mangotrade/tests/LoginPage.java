package com.mangotrade.tests;

import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginPage extends TestBase {

    @Test
    @Feature("Login page design")
    @Description("Login test 5")
    @DisplayName("Login form has form header 'Log In'")
    void checkLoginFormHeader() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("https://trade.mangotrade.com/en/login"));

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
    void succesLogin() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
                open("https://trade.mangotrade.com/en/login");
        });

        step("Set email 'mnn'", () -> {
                $("[name=identifier]").setValue("mnenie@bk.ru");
        });

        step("Set password 'Test123'", () -> {
                $("[name=password]").setValue("Test1234");
        });

        step("Click button \"Log in\"", () -> {
                $("[data-test-id=login-submit-button]").click();
                sleep(5000);
        });

        step("Redirect to 'https://trade.mangotrade.com/traderoom'", () -> {
                String currURL = getWebDriver().getCurrentUrl();
                assertEquals("https://trade.mangotrade.com/traderoom", currURL);
        });
    }

    @Test
    @Feature("Login page functional tests")
    @Description("Login test 2")
    @DisplayName("Failed login with null data")
    void failedLoginBothFieldsNull() {
        step("Open 'https://trade.mangotrade.com/en/login'", () -> {
                open("https://trade.mangotrade.com/en/login");
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
            open("https://trade.mangotrade.com/en/login");
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
            open("https://trade.mangotrade.com/en/login");
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
                open("https://trade.mangotrade.com/en/login"));

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
                open("https://trade.mangotrade.com/en/login"));

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
                open("https://trade.mangotrade.com/en/login"));

        step("'Click button 'Sing Up'", () -> {
            $("[data-test-id=header-register-button]").click();
        });

        sleep(5000);

        step("Check redirect to registration form", () -> {
            step("Check link", () -> {
                String currURL = getWebDriver().getCurrentUrl();
                assertTrue(currURL.equals("https://trade.mangotrade.com/en/register"));
            //assertEquals("https://trade.mangotrade.com/en/register", currURL);
            });

            step("Check form header -> should be 'Sing Up'", () -> {
                $(".RegisterFormContainer").$("h1").shouldHave(exactText("Sign Up"));
            });
        });
    }
}