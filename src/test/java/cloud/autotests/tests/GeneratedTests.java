package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeneratedTests extends TestBase {
    @Test
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
    @Description("Simple test 2")
    @DisplayName("'Log in' page should have warning about risks")
    void loginPageShouldHaveRiskWarning() {
        step("Open url 'https://trade.mangotrade.com/en/login'", () ->
                open("https://trade.mangotrade.com/en/login"));

        step("'Log in' page should have warning about risks", () -> {
           $("[data-test-id=auth-warning-block]").scrollIntoView(true).
                   shouldHave(exactText("All trading involves risk. Only risk capital you're prepared to lose"));
        });
    }

    @Test
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
}