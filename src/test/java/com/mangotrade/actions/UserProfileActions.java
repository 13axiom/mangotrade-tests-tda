package com.mangotrade.actions;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserProfileActions {

    @Step("Get user profile")
    public Response getUserProfile(String authorizationCookie) {
        Response response = given()
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
                .extract().response();
        return response;
    }

    @Step("Print user profile")
    public void printUserProfile(String response) {
        System.out.println(response);
    }

    @Step("Check user country")
    public boolean checkUserCountry(Response userProfile, int country_id) {
        userProfile
                .then()
                .body("result.country_id", is(country_id));
        return true;
    }

    @Step("Check user email")
    public boolean checkUserEmail(Response userProfile, String email) {
        userProfile
                .then()
                .body("result.email", is(email));
        return true;
    }

    @Step("Check user first name")
    public boolean checkUserFirstName(Response userProfile, String firstName) {
        userProfile
                .then()
                .body("result.first_name", is(firstName));
        return true;
    }

    @Step("Check user last name")
    public boolean checkUserLastName(Response userProfile, String lastName) {

        /*userProfile
                .then()
                .body("result.last_name", is(lastName));*/

        String userProfileLastName = userProfile.path("result.last_name");
        assertEquals(lastName, userProfileLastName);

        return true;
    }

    @Step("Get user id")
    public String getUserId(Response userProfile) {
        String userId = userProfile.path("result.id").toString();

        return userId;
    }

    @Step("Show user_id")
    public void showUserId(String userID) {
        System.out.println(userID);
    }
}
