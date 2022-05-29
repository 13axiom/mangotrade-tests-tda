package com.mangotrade.tests.ui;

import com.mangotrade.config.Project;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import com.mangotrade.pages.SingInPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SingInUiTests extends TestBase {
    SingInPage singInPage = new SingInPage();

    @Test
    @AllureId("10392")
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("possitive"), @Tag("login"), @Tag("ui"), @Tag("singin")})
    @Feature("Sing In page tests -> UI")
    @DisplayName("Success sing in to account")
    void successLogin() {

        singInPage.openSingInPage()
        .setUserEmail(Project.userData.userLogin())
        .setPassword(Project.userData.userPassword())
        .clickBtnLogIn();

        singInPage.checkSuccessfulLogin();
    }

}
