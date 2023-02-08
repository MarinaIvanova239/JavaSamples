package com.stepup.data.likes;

public class GetLikesParams {
    private int ownerId;

    public GetLikesParams(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
