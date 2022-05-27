package com.mangotrade.tests;

import com.github.javafaker.Faker;
import com.mangotrade.config.Project;
import com.mangotrade.helpers.DriverUtils;
import io.qameta.allure.*;
import models.LoginData;
import org.junit.jupiter.api.*;
import pages.SingInPage;
import pages.SingUpPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SingInUiTests extends TestBaseUI {
    SingInPage singInPage = new SingInPage();

    @Test
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("possitive"), @Tag("login"), @Tag("ui"), @Tag("singin")})
    @Feature("Login page functional tests")
    @DisplayName("Success login to account")
    void successLogin() {

        singInPage.openSingInPage()
        .setUserEmail(Project.userData.userLogin())
        .setPassword(Project.userData.userPassword())
        .clickBtnLogIn();

        singInPage.checkSuccessfulLogin();
    }

}
