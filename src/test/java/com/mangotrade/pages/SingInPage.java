package com.mangotrade.pages;

import com.codeborne.selenide.SelenideElement;
import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SingInPage {

    SelenideElement mainHeader = $("[data-test-id=inner-layout-content]"),
            emailInput = $("[name=identifier]"),
            passwordInput = $("[name=password]"),
            loginBtn = $("[data-test-id=login-submit-button]");

    @Step("Open login page")
    public SingInPage openSingInPage() {
        open("/en/login");
        mainHeader.shouldHave(text("Log In"));
        return this;
    }

    @Step("Set user e-mail")
    public SingInPage setUserEmail(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    @Step("Set password")
    public SingInPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Click button 'Log In'")
    public SingInPage clickBtnLogIn() {
        loginBtn.click();
        return this;
    }

    @Step("Check successful login -> redirect to Traderoom")
    public void checkSuccessfulLogin() {
        step("Check that user redirected to Traderoom", () -> {
            sleep(10000);
            String currURL = DriverUtils.getCurrUrl();
            assertEquals("https://trade.mangotrade.com/traderoom", currURL);
        });
    }
}