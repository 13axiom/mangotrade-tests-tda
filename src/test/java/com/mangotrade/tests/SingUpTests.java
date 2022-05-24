package com.mangotrade.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import pages.SingUpPage;

import java.util.Locale;


public class SingUpTests extends TestBaseUI {
    SingUpPage singUpPage = new SingUpPage();
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userCountry = "Brazil",
            userEmail = faker.internet().emailAddress(),
            existUserEmail = "mnenie@bk.ru",
            tooShortPassword = "A1234",
            tooSimplePassword = "A12345",
            simplePassword = "A1234567",
            averagePassword = "A1234567891011",
            complexPassword = "A123456.123456",
            veryComplexPassword = "A123456.12345612345",
            existUserPassword = "Test1234";


    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Registration without confirmation Terms and Conditions")
    void failedSinUpWithoutTermsAgreement() {
        singUpPage.openSingUpPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserCountry(userCountry)
                .setUserEmail(userEmail)
                .setPassword(simplePassword)
                .clickBtnOpenAcc();

        singUpPage.checkTermsConfirmationError();
    }

    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Registration with empty fields")
    void failedSinUpWithEmptyFields() {
        singUpPage.openSingUpPage()
                .clickBtnOpenAcc();

        singUpPage.checkNameValidationError()
                .checkLastNameValidationError()
                .checkCountrySelectValidationError()
                .checkEmailInputValidationError()
                .checkPasswordInputValidationError()
                .checkTermsConfirmationError();

    }

    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Registration without password")
    void failedSinUpWithoutPassword() {
        singUpPage.openSingUpPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserCountry(userCountry)
                .setUserEmail(userEmail)
                .confirmTerms()
                .clickBtnOpenAcc();

        singUpPage.checkPasswordInputValidationError();
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> too short password")
    void validateShortPasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(tooShortPassword);

        singUpPage.checkPasswordScore("Too short");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> too simple password")
    void validateTooSimplePasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(tooSimplePassword);

        singUpPage.checkPasswordScore("Too simple");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> simple password")
    void validateSimplePasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(simplePassword);

        singUpPage.checkPasswordScore("Simple");
    }

    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> average password")
    void validateAveragePasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(averagePassword);

        singUpPage.checkPasswordScore("Average");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> complex password")
    void validateComplexPasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(complexPassword);

        singUpPage.checkPasswordScore("Complex");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Validate password length -> very complex password")
    void validateVeryComplexPasswordLength() {
        singUpPage.openSingUpPage()
                .setPassword(veryComplexPassword);

        singUpPage.checkPasswordScore("Very complex");
    }

    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Failed registration with short password")
    void failedSinUpWithShortPassword() {
        singUpPage.openSingUpPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserCountry(userCountry)
                .setUserEmail(userEmail)
                .setPassword(tooShortPassword)
                .confirmTerms()
                .clickBtnOpenAcc();

        singUpPage.checkPasswordInputValidationError();
    }

    @Test
    @Tags({@Tag("negative"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Account with entered email already exists")
    void failedSinUpWithUsedEmail() {
        singUpPage.openSingUpPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserCountry(userCountry)
                .setUserEmail(existUserEmail)
                .setPassword(existUserPassword)
                .confirmTerms()
                .clickBtnOpenAcc();

        singUpPage.checkErrorForAttemptToMakeAccountWithInvalidData();
    }

    @Test
    @Tags({@Tag("disabled"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Disabled Test")
    @Disabled("Example: Test is disabled")
    void disabledTest() {
        singUpPage.openSingUpPage().clickBtnOpenAcc();

    }

    @Test
    @Tags({@Tag("failed"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.MINOR)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Example: Failed test")
    void failedTest() {
        singUpPage.openSingUpPage().clickBtnOpenAcc();
        singUpPage.checkErrorForAttemptToMakeAccountWithInvalidData();
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Successful redirect to sing in form")
    void successRedirectToSingInForm() {
        singUpPage.openSingUpPage()
                .clickSingInBtn();
        singUpPage.checkRedirectToSinInForm();
    }


    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("'Sing up' page should have warning about risks")
    void loginPageShouldHaveRiskWarning() {
        singUpPage.openSingUpPage();
        singUpPage.checkBottomWarning();
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Warning for Facebook sing up")
    void singUpWithFacebook() {
        singUpPage.openSingUpPage()
                .clickBtnSingUpWithFacebook();
        singUpPage.checkWarningWidget();
    }

    @Test
    @Tags({@Tag("positive"), @Tag("registration"), @Tag("ui"), @Tag("singup")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Warning for Google sing up")
    void singUpWithGoogle() {
        singUpPage.openSingUpPage()
                .clickBtnSingUpWithGoogle();
        singUpPage.checkWarningWidget();
    }

}
