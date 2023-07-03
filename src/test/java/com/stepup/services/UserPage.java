package com.stepup.services;

import com.stepup.data.users.User;

import static com.stepup.utils.Utils.attachTextFileFromResources;
import ru.testit.annotations.*;
import ru.testit.services.Adapter;


public class UserPage {

//    @Step("Type {user.name} / {user.password}.")
//    public void register(User user) throws Exception {
//        // register user
//        attachTextFileFromResources("userInfo");
//    }

    @Step
    @Title("Type {user.name} / {user.password}.")
    @Description("Registration description")
    public void register(User user) throws Exception {
        // register user
        Adapter.addAttachments("/logs/failed.log");
    }
}
