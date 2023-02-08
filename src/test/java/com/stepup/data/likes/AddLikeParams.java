package com.stepup.data.likes;

public class AddLikeParams {
    private final String objectType;

    AddLikeParams(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectType() {
        return objectType;
    }
}
