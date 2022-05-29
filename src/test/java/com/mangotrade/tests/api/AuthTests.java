package com.mangotrade.tests.api;

import com.mangotrade.apiActions.AuthActions;
import com.mangotrade.apiActions.CheckAnswerAction;
import com.mangotrade.config.Project;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


public class AuthTests {
    AuthActions authActions = new AuthActions();
    CheckAnswerAction checkAnswerAction = new CheckAnswerAction();

    @Test
    @AllureId("10252")
    @Tags({@Tag("positive"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Success sing in to account")
    @Description("Rest API test #1")
    void successSingIn() {
        Response auth = authActions.authorization(Project.userData.userLogin(), Project.userData.userPassword());

        checkAnswerAction.successAnswer(auth);
    }

    @Test
    @AllureId("10254")
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Wrong password")
    @Description("Rest API test #2")
    void failedSingInWrongPassword() {
        Response auth = authActions.authorization(Project.userData.userLogin(), "Test123");

        checkAnswerAction.failedAnswer(auth);
    }

    @Test
    @AllureId("10257")
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> User isn't exist")
    @Description("Rest API test #3")
    void failedSingInUserNotExist() {
        Response auth = authActions.authorization("mnenie1@bk.ru", Project.userData.userPassword());

        checkAnswerAction.failedAnswer(auth);

    }

    @Test
    @AllureId("10256")
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Login without password")
    @Description("Rest API test #4")
    void failedSingInWithoutPassword() {
        Response auth = authActions.authorization(Project.userData.userLogin(), null);

        checkAnswerAction.failedAnswer(auth);

    }

    @Test
    @AllureId("10255")
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Login without data")
    @Description("Rest API test #5")
    void failedSingInWithoutLoginData() {
        Response auth = authActions.authorization(null, null);

        checkAnswerAction.failedAnswer(auth);

    }

}