package com.stepup.tests.base;

import com.stepup.services.LikeService;

public abstract class BaseLikesTest {
    protected final static String TOKEN = "token";

    protected LikeService likeService = new LikeService();
}
