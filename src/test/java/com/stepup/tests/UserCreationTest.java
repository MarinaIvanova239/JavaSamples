package com.stepup.tests;

import com.stepup.annotations.Component;
import com.stepup.annotations.Components;
import com.stepup.data.users.User;
import com.stepup.services.UserPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature("Создание пользователя")
public class UserCreationTest {
    private final UserPage userPage = new UserPage();

    @Test
    @Link("https://example.org")
    @Issue("bug-123")
    @Story("Главная страница")
    @DisplayName("Создание пользователя через главную страницу")
    @Description("Делаем тут умные вещи")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("12471")
    @Components({@Component("service1"), @Component("service2")})
    public void testUserRegistrationViaMainPage() throws Exception {
        userPage.register(new User());
    }
}
