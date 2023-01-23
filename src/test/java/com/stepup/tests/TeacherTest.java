package com.stepup.tests;

import com.stepup.annotations.CourseTestClass;
import com.stepup.annotations.CourseTestMethod;
import org.junit.Test;

@CourseTestClass
public class TeacherTest {

    @Test
    @CourseTestMethod(type = "first")
    public void firstTest() {
        System.out.println("Teachers test 1");
    }

    @Test
    @CourseTestMethod(type = "second")
    public void secondTest() {
        System.out.println("Teachers test 2");
    }
}
