package com.stepup.tests;

import com.stepup.annotations.CourseParticipantAnnotation;
import com.stepup.common.Student;
import org.junit.Test;

public class AnnotationTest {

    @Test
    public void annotationTest() {
        CourseParticipantAnnotation annotation = Student.class.getAnnotation(CourseParticipantAnnotation.class);
        System.out.println(annotation.name());
    }
}
