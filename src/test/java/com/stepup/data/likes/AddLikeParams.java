package com.stepup.data.likes;

public class AddLikeParams {
    private int ownerId;

    public AddLikeParams(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
