package com.mangotrade.tests.api;

import com.mangotrade.apiActions.AuthActions;
import com.mangotrade.apiActions.UserProfileActions;
import com.mangotrade.config.Project;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class UserProfileTests {

    @Test
    @AllureId("10251")
    @Tags({@Tag("positive"), @Tag("user_profile"), @Tag("rest_api"), @Tag("profile")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("User Profile -> REST_API")
    @DisplayName("Check User Data")
    @Description("Rest API test #6")
    void checkProfile() {
        AuthActions authActions = new AuthActions();
        UserProfileActions userProfileActions = new UserProfileActions();

        String ssid = authActions.getAuthorizationCookie();
        Response userProfile = userProfileActions.getUserProfile(ssid);

        userProfileActions.checkUserFirstName(userProfile, Project.userData.firstName());
        userProfileActions.checkUserLastName(userProfile, Project.userData.lastName());
        userProfileActions.checkUserEmail(userProfile, Project.userData.userLogin());
        userProfileActions.checkUserCountry(userProfile, Project.userData.userCountry());

        String userId = userProfileActions.getUserId(userProfile);
        userProfileActions.showUserId(userId);

    }

    @Test
    @Tags({@Tag("positive"), @Tag("user_profile"), @Tag("rest_api"), @Tag("profile")})
    @Owner("DmitriyTQC")
    @Severity(SeverityLevel.NORMAL)
    @Feature("User Profile -> REST_API")
    @DisplayName("Validate JSON Schema of User Profile")
    @Description("Rest API test #7")
    void validateJSONSchemaUserProfile() {
        AuthActions authActions = new AuthActions();
        UserProfileActions userProfileActions = new UserProfileActions();

        String ssid = authActions.getAuthorizationCookie();
        Response userProfile = userProfileActions.getUserProfile(ssid);

        userProfile.then()
                .assertThat().body(matchesJsonSchemaInClasspath("schemas/userProfile.json"));
    }

}