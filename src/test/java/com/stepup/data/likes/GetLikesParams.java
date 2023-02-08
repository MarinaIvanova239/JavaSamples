package com.stepup.data.likes;

public class GetLikesParams {
    private final String objectType;

    GetLikesParams(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectType() {
        return objectType;
    }
}
