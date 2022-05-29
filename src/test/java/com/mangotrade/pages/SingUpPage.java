package com.mangotrade.pages;

import com.codeborne.selenide.SelenideElement;
import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SingUpPage {

    SelenideElement mainHeader = $("[data-test-id=inner-layout-content]"),

    commonNameInput = $("[data-test-id=register-form-name-input]"),
            firstNameInputField = $("[name=first_name]"),

    commonLastNameInput = $("[data-test-id=register-last-name-input]"),
            lastNameInput = $("[name=last_name]"),

    commonRegCountrySelect = $("[data-test-id=register-form-country-wrapper]"),
            regCountrySelect = $("[data-test-id=register-country-select-select_header]"),

    commonEmailInput = $("[data-test-id=register-email-input]"),
            emailInput = $("[name=identifier]"),

    commonPasswordInput = $("[data-test-id=register-password2-input]"),
            passwordInput = $("[name=password]"),
            passwordScore = $("[data-test-id=password-strength_block]")
                    .$("[data-test-id=score_block]"),

    termsConfirmationCheckbox = $(".css-1gwpupm.e1ecsjp50"),
            commonTermsCheckbox = $(".css-h0pgyk.e820hvr0"),
            btnOpenAcc = $("[data-test-id=register-submit-button]"),

    commonErrorAfterSingUpBtn = $(".css-qelm4e.eye9xby0"),
            warning = $("[data-test-id=auth-warning-block]"),
            loginBtn = $("[data-test-id=header-login-button]"),
            loginHeader = $(".css-1ffs9d1.e131aulr0"),
    btnSingUpWithFacebook = $("[data-test-id=right-bar_facebook]"),
    btnSingUpWithGoogle = $("[data-test-id=right-bar_google]"),
    warningWidgetText = $(".css-sp8jt5.eirxtu5"),
    warningWidgetConfirmBtn = $(".eirxtu6.css-ffyfk2.e1qay7kl0");

    @Step("Open registration page")
    public SingUpPage openSingUpPage() {
        open("/en/register");
        mainHeader.shouldHave(text("Sign Up"));
        return this;
    }


    @Step("Set First Name")
    public SingUpPage setFirstName(String firstName) {
        firstNameInputField.setValue(firstName);
        return this;
    }

    @Step("Set Last Name")
    public SingUpPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Set user country")
    public SingUpPage setUserCountry(String userCountry) {
        regCountrySelect.click();
        $$(".css-5lcadx.eq8l2cl7").findBy(text(userCountry)).click();
        return this;
    }

    @Step("Set user e-mail")
    public SingUpPage setUserEmail(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    @Step("Set password")
    public SingUpPage setPassword(String password) {
        passwordInput.setValue(password);
        passwordInput.click();
        return this;
    }

    @Step("Confirm Terms & Conditions and Privacy Policy")
    public SingUpPage confirmTerms() {
        termsConfirmationCheckbox.click();
        return this;
    }

    @Step("Click button 'Open an Account for Free'")
    public SingUpPage clickBtnOpenAcc() {
        btnOpenAcc.click();
        return this;
    }

    @Step("Check name validation error")
    public SingUpPage checkNameValidationError() {
        commonNameInput.$(".e1r16e9h3").shouldHave(text("Fill out the field"));
        return this;
    }

    @Step("Check last name validation error")
    public SingUpPage checkLastNameValidationError() {
        commonLastNameInput.$(".e1r16e9h3").shouldHave(text("Fill out the field"));
        return this;
    }

    @Step("Check country select validation error")
    public SingUpPage checkCountrySelectValidationError() {
        commonRegCountrySelect.$(".e1r16e9h3").shouldHave(text("Fill out the field"));
        return this;
    }

    @Step("Check email input validation error")
    public SingUpPage checkEmailInputValidationError() {
        commonEmailInput.$(".e1r16e9h3").shouldHave(text("Fill out the field"));
        return this;
    }

    @Step("Check password input validation error")
    public SingUpPage checkPasswordInputValidationError() {
        commonPasswordInput.$(".e1r16e9h3").shouldHave(text("Your password must be at least 6 characters long"));
        return this;
    }

    @Step("Check Terms confirmation error")
    public SingUpPage checkTermsConfirmationError() {
        commonTermsCheckbox.$(".e1r16e9h3").shouldHave(text("Required field"));
        return this;
    }

    @Step("Check password score")
    public SingUpPage checkPasswordScore(String score) {
        passwordScore.shouldHave(text(score));
        return this;
    }


    @Step("Check Error after attempt to make new account with invalid data")
    public SingUpPage checkErrorForAttemptToMakeAccountWithInvalidData() {
        commonErrorAfterSingUpBtn.shouldHave(text("A user account with this email address already exists"));
        return this;
    }

    @Step("'Log in' page should have warning about risks")
    public SingUpPage checkBottomWarning() {
        warning.scrollIntoView(true).
                shouldHave(exactText("Risk Warning: All trading involves risk. Only risk capital you're prepared to lose."));
        return this;
    }

    @Step("Click button 'Sing In")
    public SingUpPage clickSingInBtn() {
        loginBtn.click();
        return this;
    }

    @Step("Check redirect to sing in form")
    public SingUpPage checkRedirectToSinInForm() {
        step("Check link", () -> {
            sleep(10000);
            String currURL = DriverUtils.getCurrUrl();
            assertEquals("https://trade.mangotrade.com/en/login", currURL);
        });

        step("Check form header -> should be 'Log In'", () -> {
            loginHeader.shouldHave(exactText("Log In"));
        });
        return this;
    }

    @Step("Click button 'Sing Up with Facebook")
    public SingUpPage clickBtnSingUpWithFacebook() {
        btnSingUpWithFacebook.click();
        return this;
    }

    @Step("Click button 'Sing Up with Google")
    public SingUpPage clickBtnSingUpWithGoogle() {
        btnSingUpWithGoogle.click();
        return this;
    }

    @Step("Check warning widget")
    public SingUpPage checkWarningWidget() {
        warningWidgetText
                .shouldHave(text("To sign up via Social Accounts, please confirm " +
                        "that you are 18 years old or older and accept Terms & Conditions and Privacy Policy"));
        warningWidgetConfirmBtn.shouldHave(text("Confirm"));
        return this;
    }
}
