package com.stepup.annotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@LabelAnnotation(name = "component")
@Repeatable(Components.class)
public @interface Component {
    String value();
}
