package com.stepup.utils;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    public static byte[] attachTextFileFromResources(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }
}
