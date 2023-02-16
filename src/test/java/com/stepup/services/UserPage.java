package com.stepup.services;

import com.stepup.data.users.User;
import io.qameta.allure.Step;

import static com.stepup.utils.Utils.attachTextFileFromResources;

public class UserPage {

    @Step("Type {user.name} / {user.password}.")
    public void register(User user) throws Exception {
        // register user
        attachTextFileFromResources("userInfo");
    }
}
