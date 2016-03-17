package com.betterman.algorithms.leetcode2.medium;

/**
 * Created by zhuangda on 3/14/16.
 */
public class IntegerToRoman {
    public static class Solution {
        public static final int[] intDict = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        public static final String[] romanDict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (num > 0) {
                if (num >= intDict[i]) {
                    sb.append(romanDict[i]);
                    num -= intDict[i];
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
    }
}
