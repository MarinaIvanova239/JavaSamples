package com.stepup.tests.generics;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static com.google.common.primitives.Ints.asList;
import static com.stepup.generics.GenericsExamples.genericsWithHierarchy;

public class GenericsTest {

    @Test
    public void runGeneric() {
        genericsWithHierarchy();
    }


    @Test
    public void sortingWithComparator() {
        List<Integer> numbersList = asList(1, 2, 3, 4);

        Comparator<Integer> reversedOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        };

        numbersList.sort(reversedOrder);
    }

    @Test
    public void sortingWithLambda() {
        List<Integer> numbersList = asList(1, 2, 3, 4);

        numbersList.sort((n1, n2) -> n2 - n1);
    }

}
