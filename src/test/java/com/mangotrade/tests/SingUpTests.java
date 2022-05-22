package com.mangotrade.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

import pages.SingUpPage;

public class    SingUpTests extends TestBase {
    SingUpPage singUpPage = new SingUpPage();


    @Test
    @Tags({@Tag("negative"), @Tag("registration")})
    //@Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Validation of registration form -> UI")
    @DisplayName("Registration without confirmation Terms and Conditions")
    void failedSinUpWithEmptyFields() {
        singUpPage.openSingUpPage()
                .setFirstName("112233")
                .setLastName("332211")
                .setUserCountry("Brazil")
                .setUserEmail("abc@def.com")
                .setPassword("A1234567")
                .clickBtnOpenAcc();
        sleep(5000);

        singUpPage.checkTermsConfirmationError();
    }

   /* @Test
    @Tags({@Tag("negative"), @Tag("registration")})
    //@Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Подключаем Jenkins с Allure report")
    @DisplayName("RegistrationWithEmptyFields")
    void failedSinUpWithEmptyFields() {
        singUpPage.openSingUpPage()

        sleep(5000);

    }*/
}
