package com.stepup.data.likes;

import java.util.List;

public class UserLikesList {
    private List<Integer> users;

    public UserLikesList(List<Integer> users) {
        this.users = users;
    }

    public int getUsersCount() {
        return users.size();
    }
}
