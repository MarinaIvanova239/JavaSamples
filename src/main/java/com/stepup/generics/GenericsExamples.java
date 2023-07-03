package com.stepup.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class GenericsExamples {

    public static void genericsWithNoType() {
        List<String> stringsList =  new ArrayList<>(asList("s1", "s2"));
        // ...
        // ...
        List preparedDataList = new ArrayList<Long>(asList(1L, 2L, 3L));
        preparedDataList = stringsList;
        preparedDataList.add(4L);
        // ...
        // ...
    }


    public static void genericsWithHierarchy() {
        List<? extends Long> longList = asList(1L, 2L, 3L);
        List<? extends Number> numbersList = asList(1, 2, 3);
        numbersList = longList;
    }


    public static void genericsWithIncreasingList() {
        List<Integer> numbers = new ArrayList<>(asList(1, 2));
        addNewElement(numbers, 3);
    }

    public static void addNewElement(List<? super Integer> list, Integer elementValue) {
        list.get(elementValue);
    }


    public int resolveStatusCode(String parameter) {
        return 1;
    }

    public int resolveStatusCode(Long parameter) {
        return 2;
    }


    @FunctionalInterface
    interface Result {
        void print();
    }

    Result successResult = () -> System.out.println("Success");
    Result failResult = () -> System.out.println("Fail");

    public void finishExecution(Result funResult) {
        // do smth
        funResult.print();
    }

    static int counter = 0;

    public static void counterInStreamTest() {
//        int counter = 0;
        IntStream.range(0, 4).forEach(i -> counter += i);
    }


    public void listInStreamTest() {
        List<Integer> numbersList = asList(1, 2, 3, 4);

        IntStream.range(0, 4)
                .forEach(i -> numbersList.add(numbersList.get(i) + i));
    }

    public void parallelStreamTest1() {
        List<Integer> numbersList = asList(1, 2, 3, 4);

        numbersList.parallelStream()
                .mapToInt(i -> i + 5)
                .forEach(i -> System.out.println("number = " + i));
    }


    public void parallelStreamTest2() {
        List<Integer> numbersList = asList(1, 2, 3, 4);

        numbersList.parallelStream()
                .filter(i -> i != 2)
                .mapToInt(i -> i + 5)
                .forEachOrdered(i -> System.out.println(" number = " + i));
    }




}
