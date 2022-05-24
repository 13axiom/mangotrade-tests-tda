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


public class UserProfileTests {

    @Test
    @Tags({@Tag("positive"), @Tag("user_profile"), @Tag("rest_api"), @Tag("profile")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("User Profile -> REST_API")
    @DisplayName("Check User Data")
    @Description("Rest API test #6")
    void checkProfile() {
        AuthActions authActions = new AuthActions();
        UserProfileActions userProfileActions = new UserProfileActions();
        LoginData data = new LoginData();

        String ssid = authActions.getAuthorizationCookie();
        Response userProfile = userProfileActions.getUserProfile(ssid);

        userProfileActions.checkUserFirstName(userProfile, Project.userData.firstName());
        userProfileActions.checkUserLastName(userProfile,Project.userData.lastName());
        userProfileActions.checkUserEmail(userProfile,Project.userData.userLogin());
        userProfileActions.checkUserCountry(userProfile, Project.userData.userCountry());

        String userId = userProfileActions.getUserId(userProfile);
        userProfileActions.showUserId(userId);

    }


}