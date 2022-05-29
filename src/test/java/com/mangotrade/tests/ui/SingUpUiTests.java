package com.mangotrade.tests.ui;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import com.mangotrade.pages.SingUpPage;

import java.util.Locale;


public class SingUpUiTests extends TestBase {
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
    @AllureId("10270")
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
    @AllureId("10267")
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
    @AllureId("10262")
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
    @AllureId("10258")
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
    @AllureId("10269")
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
    @AllureId("10265")
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
    @AllureId("10260")
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
    @AllureId("10268")
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
    @AllureId("10271")
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
    @AllureId("10273")
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
    @AllureId("10259")
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
    @AllureId("10253")
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
    @AllureId("10272")
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
    @AllureId("10264")
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
    @AllureId("10266")
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
    @AllureId("10261")
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
    @AllureId("10263")
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
