package com.betterman.algorithms.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 7/19/17.
 */
public class Lambda {
    public static void main(String[] args) {
        Integer[] arr = {1, 1, 231, 121, 213, 1214};
        List<Integer> list = Arrays.asList(arr);
        list.sort((i1, i2) -> i1 - i2);

        list.forEach(item -> System.out.print(item+ " "));
    }

}
