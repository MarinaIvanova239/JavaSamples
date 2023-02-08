package com.stepup.tests;

import com.stepup.data.error.ErrorDescription;
import com.stepup.data.likes.AddLikeParams;
import com.stepup.data.likes.GetLikesParams;
import com.stepup.data.likes.LikesCount;
import com.stepup.tests.base.BaseLikesTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddLikesTest extends BaseLikesTest {

    @Test
    public void likesCanBeAddedToDifferentObjectsTest() throws Exception {
        // given
        int ownerId = 43525;
        int likesCountBeforeTest = likeService.getLikes(new GetLikesParams(ownerId), TOKEN).getUsersCount();
        AddLikeParams addLikeParams = new AddLikeParams(ownerId);
        // when
        LikesCount addLikeResult = likeService.addLike(addLikeParams, TOKEN);
        // then
        assertThat("Likes count should be increased by 1", addLikeResult.getLikesCount() == likesCountBeforeTest + 1);
    }

    @Test
    public void likesCannotBeAddedToObjectOnPrivatePage() throws Exception {
        // given
        AddLikeParams addLikeParams = new AddLikeParams(85645519);
        // when
        ErrorDescription errorDescription = likeService.addLikeWithExpectingError(addLikeParams, TOKEN);
        // then
        assertThat("Expect status code = 30, but actual " + errorDescription.getCode(), errorDescription.getCode() == 30);
    }
}
