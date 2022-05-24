package com.mangotrade.tests;

import com.mangotrade.actions.AuthActions;
import com.mangotrade.actions.UserProfileActions;
import com.mangotrade.config.Project;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import models.LoginData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.mangotrade.tests.Specs.*;
import static io.restassured.RestAssured.given;


public class LoginPage {


    @Test
    @Tags({@Tag("positive"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Success sing in to account")
    @Description("Rest API test #1")
    void successSingIn() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());
        data.setPassword(Project.userData.userPassword());

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(successResponseSpec);

    }


    @Test
    @Tags({@Tag("positive"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("TMP -> REST_API")
    @DisplayName("Success sing in to account")
    @Description("Rest API test #01-2")
    void successSingIn2() {

        AuthActions authActions = new AuthActions();
        authActions.authorization();
    }


    @Test
    @Tags({@Tag("positive"), @Tag("user_profile"), @Tag("rest_api"), @Tag("profile")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("TMP -> REST_API")
    @DisplayName("Check User Data")
    @Description("Rest API test #06-2")
    void checkProfile2() {
        AuthActions authActions = new AuthActions();
        UserProfileActions userProfileActions = new UserProfileActions();
        LoginData data = new LoginData();
        data.setFirstName(Project.userData.firstName());

        String ssid = authActions.getAuthorizationCookie();
        Response userProfile = userProfileActions.getUserProfile(ssid);


        userProfileActions.checkUserFirstName(userProfile, Project.userData.firstName());
        userProfileActions.checkUserLastName(userProfile,Project.userData.lastName());
        userProfileActions.checkUserEmail(userProfile,Project.userData.userLogin());
        userProfileActions.checkUserCountry(userProfile, Project.userData.userCountry());

        String userId = userProfileActions.getUserId(userProfile);
        userProfileActions.showUserId(userId);



    }

    @Test
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Wrong password")
    @Description("Rest API test #2")
    void failedSingInWrongPassword() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());
        data.setPassword("Test123");

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(failedResponseSpec);
    }

    @Test
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> User isn't exist")
    @Description("Rest API test #3")
    void failedSingInUserNotExist() {
        LoginData data = new LoginData();
        data.setIdentifier("mnenie1@bk.ru");
        data.setPassword(Project.userData.userPassword());

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(failedResponseSpec);
    }

    @Test
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Login without password")
    @Description("Rest API test #4")
    void failedSingInWithoutPassword() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(failedResponseSpec);
    }

    @Test
    @Tags({@Tag("negative"), @Tag("login"), @Tag("rest_api"), @Tag("singin")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sing In page tests -> REST_API")
    @DisplayName("Failed sing in to account -> Login without data")
    @Description("Rest API test #5")
    void failedSingInWithoutLoginData() {
        LoginData data = new LoginData();

        given()
                .spec(request)
                .body(data)
                .when()
                .post("/api/v2/login")
                .then()
                .spec(failedResponseSpec);
    }


    @Test
    @Tags({@Tag("positive"), @Tag("user_profile"), @Tag("rest_api"), @Tag("profile")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("User Profile -> REST_API")
    @DisplayName("Check User Data")
    @Description("Rest API test #6")
    void checkUserProfile() {
        LoginData data = new LoginData();
        data.setIdentifier(Project.userData.userLogin());
        data.setPassword(Project.userData.userPassword());

        String authorizationCookie =
                given()
                        .spec(request)
                        .body(data)
                        .when()
                        .post("/api/v2/login")
                        .then()
                        .statusCode(200)
                        .extract()
                        .cookie("ssid");

        String response = given()
                .filter(new AllureRestAssured())
                .cookie("ssid", authorizationCookie)
                .header("Connection", "keep-alive")
                .log().uri()
                .log().body()
                .when()
                .get("https://trade.mangotrade.com/api/getprofile")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().asString();

        System.out.println(response);
    }

}