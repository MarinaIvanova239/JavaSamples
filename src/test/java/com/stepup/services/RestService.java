package com.stepup.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepup.common.ErrorDescription;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.function.BiFunction;

import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestService {

    private ObjectMapper mapper() {
        return new ObjectMapper();
    }

    protected <T> Response executeRequestIgnoringTooManyRequests(T params, String token, BiFunction<T, String, Response> requestFunc) throws Exception {
        Response likeRs = requestFunc.apply(params, token);
        for (int i: asList(1, 2)) {
            if (requestReturnTooManyRequestsError(likeRs)) {
                Thread.sleep(1_000);
                likeRs = requestFunc.apply(params, token);
            } else break;
        }
        return likeRs;
    }

    protected <T> T mapWithStatusCheck(Response value, Class<T> valueType, String objectDescription,
                                       ObjectMapper mapper, String responsePath) throws Exception {
        assertThat("Request should be successfully executed, but actual " + value.getStatusCode(),
                value.getStatusCode() == 200);
        T resultBody = valueType.newInstance();
        try {
            JsonNode responseJsonNode = mapper.readTree(value.getBody().asString()).path(responsePath);
            assertThat("Expected " + responsePath + " field to be present, but it was not", !responseJsonNode.isMissingNode());
            resultBody = mapper.treeToValue(responseJsonNode, valueType);
        } catch (Exception e) {
            Assert.fail("Exception occurred while processing json: " + e.getMessage());
        }
        assertThat(objectDescription + " should not be null", nonNull(resultBody));
        return resultBody;
    }

    protected ErrorDescription mapWithExpectingError(Response value, String objectDescription) throws Exception {
        return mapWithStatusCheck(value, ErrorDescription.class, objectDescription, mapper(), "error");
    }

    protected Boolean requestReturnTooManyRequestsError(Response value) throws JsonProcessingException {
        JsonNode responseJsonNode = mapper().readTree(value.getBody().asString()).path("error");
        if (responseJsonNode.isMissingNode()) return false;
        if (mapper().treeToValue(responseJsonNode, ErrorDescription.class).getCode() == 6) return true;
        return false;
    }

    protected RequestSpecification request(String accessToken) {
        return RestAssured.given()
                .baseUri("https://api.vk.com/method/")
                .accept(ContentType.JSON)
                .param("access_token", accessToken)
                .param("v", "5.131");
    }
}
