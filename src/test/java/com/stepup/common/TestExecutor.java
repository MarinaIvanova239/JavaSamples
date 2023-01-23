package com.stepup.common;

import com.stepup.annotations.CourseTestClass;
import com.stepup.annotations.CourseTestMethod;
import com.stepup.tests.AnnotationTest;
import com.stepup.tests.StudentTest;
import com.stepup.tests.TeacherTest;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestExecutor {

    @Test
    public void checkAnnotations() {
        for (Class myClass : asList(AnnotationTest.class, StudentTest.class, TeacherTest.class)) {
            if (myClass.getAnnotation(CourseTestClass.class) != null) {
                long count = Arrays.stream(myClass.getMethods())
                        .filter(method -> method.getAnnotation(CourseTestMethod.class) != null &&
                                method.getAnnotation(CourseTestMethod.class).type().equals("second"))
                        .count();
                assertThat("Check counter", count == 1);
            }
        }
    }
}
