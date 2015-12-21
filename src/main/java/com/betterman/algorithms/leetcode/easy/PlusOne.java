package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/20/15.
 */
public class PlusOne {
    public class Solution {
        //naive
        public int[] plusOne(int[] digits) {
            int c = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int tmp = digits[i] + c;
                digits[i] = tmp % 10;
                c = tmp / 10;
            }

            if (c > 0) {
                int[] res = new int[digits.length + 1];
                res[0] = c;
                for (int i = 0; i < digits.length; i++) {
                    res[i + 1] = digits[i];
                }
                return res;
            }
            else return digits;
        }

        //smart
        public int[] plusOneSmart(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;
            }

            int[] newNumber = new int[digits.length + 1];
            newNumber[0] = 1;
            return newNumber;
        }
    }
}
