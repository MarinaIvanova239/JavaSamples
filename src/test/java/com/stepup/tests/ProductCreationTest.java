package com.stepup.tests;

import com.stepup.data.users.User;
import com.stepup.services.UserPage;
import org.junit.Test;
import ru.testit.annotations.*;
import ru.testit.models.LinkType;

public class ProductCreationTest {
    private final UserPage userPage = new UserPage();

    @Test
    @WorkItemIds({"12345","54321"})
    @DisplayName("Simple test 2")
    @Title("test №2")
    @Description("Description")
    @Link(url = "my-url", type = LinkType.DEFECT)
    @ExternalId("760")
    public void testUserRegistrationViaMainPage() throws Exception {
        userPage.register(new User());
    }
}
