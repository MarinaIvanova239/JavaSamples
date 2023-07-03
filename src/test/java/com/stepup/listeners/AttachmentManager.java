package com.stepup.listeners;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.testit.services.Adapter;

import java.io.ByteArrayInputStream;

public class AttachmentManager extends RunListener {

    @Override
    public void testFailure(Failure failure) {
        // Add a screenshot
        ByteArrayInputStream screenshot = new ByteArrayInputStream((
                (TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        Adapter.addAttachments(String.valueOf(screenshot), "Screenshot.jpg");
    }
}
