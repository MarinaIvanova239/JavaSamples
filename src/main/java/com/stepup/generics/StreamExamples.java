package com.stepup.generics;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class StreamExamples {

    public static class Student {
        private String name;
        private int age;
        private Integer groupNumber;

        public Student(String name, int age, Integer groupNumber) {
            this.name = name;
            this.age = age;
            this.groupNumber = groupNumber;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        Integer getGroupNumber() {
            return groupNumber;
        }
    }


    public List<String> getStudentNames(Student[] students) {
        return Arrays.stream(students)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 30)
                .filter(student -> student.getGroupNumber() == 2)
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    public int getStudentAgesSummary(Student[] students) throws Exception {
        return Arrays.stream(students)
                .filter(student -> student.getName().startsWith("А") || student.getName().startsWith("Б"))
                .filter(student -> student.getGroupNumber() == 1)
                .map(Student::getAge)
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new Exception("No students present"));
    }



    public <T> List<T> addNewElement(List<T> elementsList,
                                       Class<T> elemClass) throws Exception {
        T newElement = elemClass.newInstance();
        elementsList.add(newElement);
        return elementsList;
    }


}
