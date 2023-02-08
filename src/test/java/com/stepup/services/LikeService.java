package com.stepup.services;

import com.stepup.data.error.ErrorDescription;
import com.stepup.data.likes.AddLikeParams;
import com.stepup.data.likes.GetLikesParams;
import com.stepup.data.likes.LikesCount;
import com.stepup.data.likes.UserLikesList;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LikeService extends RestService {

    // add like
    public LikesCount addLike(AddLikeParams addLikeParams, String accessToken) throws Exception {
        Response addLikeRs = executeRequestIgnoringTooManyRequests(addLikeParams, accessToken, this::addLikeResponse);
        return mapWithStatusCheck(addLikeRs, LikesCount.class, "add like", "response");
    }

    public ErrorDescription addLikeWithExpectingError(AddLikeParams addLikeParams, String accessToken) throws Exception {
        Response addLikeRs = addLikeResponse(addLikeParams, accessToken);
        return mapWithExpectingError(addLikeRs, "add like");
    }

    private Response addLikeResponse(AddLikeParams addLikeParams, String accessToken) {
        RequestSpecification addLikeRq = request(accessToken)
                .param("type", addLikeParams.getObjectType());
        return addLikeRq.post("likes.add");
    }

    // get likes
    public UserLikesList getLikes(GetLikesParams getLikesParams, String accessToken) throws Exception {
        Response getLikesRs = executeRequestIgnoringTooManyRequests(getLikesParams, accessToken, this::getLikesResponse);
        return mapWithStatusCheck(getLikesRs, UserLikesList.class, "get user likes", "response");
    }

    public ErrorDescription getLikesWithExpectingError(GetLikesParams getLikesParams, String accessToken) throws Exception {
        Response getLikeRs = getLikesResponse(getLikesParams, accessToken);
        return mapWithExpectingError(getLikeRs, "add like");
    }

    private Response getLikesResponse(GetLikesParams getLikesParams, String accessToken) {
        RequestSpecification getLikesRq =  request(accessToken)
                .param("type", getLikesParams.getObjectType());

        return getLikesRq.get("likes.getList");
    }
}
