package com.mangotrade.actions;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.mangotrade.tests.Specs.failedResponseSpec;
import static com.mangotrade.tests.Specs.successResponseSpec;

public class CheckAnswerAction {
    @Step("Actual Result: Successful answer")
    public void successAnswer(Response response) {
        response.then()
                .spec(successResponseSpec);

    }

    @Step("Actual Result: Failed answer")
    public void failedAnswer(Response response) {
        response.then()
                .spec(failedResponseSpec);

    }
}
