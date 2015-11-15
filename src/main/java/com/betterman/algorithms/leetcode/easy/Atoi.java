package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 10/19/15.
 */
public class Atoi {
    public static class Solution {
        public int myAtoi(String str) {
            // 0.ASK what to return if following cases happen
            // 1.negative;
            // 2.overflow int;
            // 3.not digit;
            // 4.empty space;
            // 5.overflow long
            if (str == null) {
                return 0;
            }

            str = str.trim();

            if (str.length() == 0) {
                return 0;
            }

            long result = 0;
            boolean isNegative = false;
            if (str.charAt(0) == '-') {
                isNegative = true;
                str = str.substring(1, str.length());
            } else if (str.charAt(0) == '+') {
                str = str.substring(1, str.length());
            }

            for (int i = 0; i < str.length(); i++) {
                char digit = str.charAt(i);
                if (digit < '0' || digit > '9') {
                    break;
                }

                result = result * 10 + str.charAt(i) - '0';

                if (result > Integer.MAX_VALUE) {
                    break;
                }
            }

            if (isNegative) {
                result *= -1;
            }

            if (result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }


            if (result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            return (int) result;
        }
    }
}
