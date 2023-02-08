package com.stepup.tests;

import com.stepup.data.error.ErrorDescription;
import com.stepup.data.likes.GetLikesParams;
import com.stepup.data.likes.UserLikesList;
import com.stepup.tests.base.BaseLikesTest;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import static org.unitils.reflectionassert.ReflectionComparatorMode.LENIENT_ORDER;

public class GetLikesTest extends BaseLikesTest {

    @Test
    public void getLikesError() throws Exception {
        // given
        GetLikesParams getLikeParams = new GetLikesParams(-22822305);
        // when
        ErrorDescription errorDescription = likeService.getLikesWithExpectingError(getLikeParams, TOKEN);
        // then
        assertThat("Expect status code = 100, but actual " + errorDescription.getCode(),
                errorDescription.getCode() == 100);
    }

    @Test
    public void getLikesSuccess() throws Exception {
        // given
        GetLikesParams getLikeParams = new GetLikesParams(9599485);
        // when
        UserLikesList getCopiesResult = likeService.getLikes(getLikeParams, TOKEN);
        // then
        assertReflectionEquals(new UserLikesList(asList(1, 2)), getCopiesResult, LENIENT_ORDER);
    }
}
