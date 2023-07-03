package com.stepup.tests.generics;

import com.stepup.generics.StreamExamples;
import org.junit.Test;

import java.lang.reflect.Field;

public class StreamTest {

    @Test
    public void studentsTest() throws Exception {
        StreamExamples.Student newStudent = new StreamExamples.Student(
                "Ivan", 30, null);
        String studentName = getStudentName(newStudent);
        System.out.println("Student name: " + studentName);
    }

    private String getStudentName(StreamExamples.Student student) throws Exception {
        Field ageField = student.getClass().getDeclaredField("name");
        ageField.setAccessible(true);
        return (String) ageField.get(student);
    }
}
