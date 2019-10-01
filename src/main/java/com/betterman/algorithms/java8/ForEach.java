package com.betterman.algorithms.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 7/19/17.
 */
public class ForEach {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("D", 10);
        map.put("E", 10);
        map.put("B", 10);
        map.put("C", 10);

        map.forEach((key, val) -> {
            System.out.println("Key: " + key + "; " + "Value: " + val);
            if ("E".equals(key)) {
                System.out.println("Hello, E!");
            }
        });
    }
}
