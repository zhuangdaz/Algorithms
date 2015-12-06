package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 12/5/15.
 */
public class RomanToInt {
    public static class Solution {
        // I 1 V 5 X 10 L 50 C 100 D 500 M 1000
        static Map<Character, Integer> units = new HashMap();

        static {
            units.put('I', 1);
            units.put('V', 5);
            units.put('X', 10);
            units.put('L', 50);
            units.put('C', 100);
            units.put('D', 500);
            units.put('M', 1000);
        }

        public int romanToInt(String s) {
            char[] chars = s.toCharArray();
            int ret = units.get(chars[chars.length - 1]);

            for (int i = 0; i < chars.length - 1; i++) {
                if (units.get(chars[i]) < units.get(chars[i + 1])) {
                    ret -= units.get(chars[i]);
                } else {
                    ret += units.get(chars[i]);
                }
            }

            return ret;
        }
    }
}
