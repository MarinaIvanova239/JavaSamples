package com.stepup.tests;

import com.stepup.annotations.CourseTestClass;
import com.stepup.annotations.CourseTestMethod;
import org.junit.Test;

@CourseTestClass
public class StudentTest {

    @Test
    @CourseTestMethod(type = "first")
    public void firstTest() {
        System.out.println("Student test 1");
    }

    @Test
    @CourseTestMethod(type = "second")
    public void secondTest() {
        System.out.println("Student test 2");
    }

    @Test
    @CourseTestMethod(type = "third")
    public void thirdTest() {
        System.out.println("Student test 3");
    }
}
