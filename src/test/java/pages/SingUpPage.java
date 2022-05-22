package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SingUpPage {

    SelenideElement mainHeader = $("[data-test-id=inner-layout-content]"),
            firstNameInput = $("[name=first_name]"),
            lastNameInput = $("[name=last_name]"),
            regCountrySelect = $("[data-test-id=register-country-select-select_header]"),
            emailInput = $("[name=identifier]"),
            passwordInput = $("[name=password]"),
            termsConfirmationCheckbox = $(".css-1gwpupm.e1ecsjp50"),
            validationError = $(".css-1jgw7zx.e1r16e9h3"),
            btnOpenAcc = $("[data-test-id=register-submit-button]");


    @Step("Open registration page")
    public SingUpPage openSingUpPage() {
        open("/en/register");
        mainHeader.shouldHave(text("Sign Up"));
        return this;
    }

    @Step("Set First Name")
    public SingUpPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
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
        return this;
    }

    @Step("Confirm Terms & Conditions and Privacy Policy")
    public SingUpPage confirmTerms(String confrimTerms) {
        termsConfirmationCheckbox.setValue(confrimTerms);
        return this;
    }

    @Step("Check Terms cofirmation error")
    public SingUpPage checkTermsConfirmationError() {
        validationError.shouldHave(text("Required field"));
        return this;
    }

    @Step("Click button 'Open an Account for Free'")
    public SingUpPage clickBtnOpenAcc() {
        btnOpenAcc.click();
        return this;
    }

}
