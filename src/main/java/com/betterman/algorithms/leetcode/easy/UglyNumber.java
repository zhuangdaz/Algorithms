package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/21/16.
 */
public class UglyNumber {
    public class Solution {
        public boolean isUgly(int num) {
            if (num == 1) return true;
            if (num == 0) return false;
            int[] factors = new int[]{2, 3, 5};

            for (int f : factors) {
                while (num % f == 0) num /= f;
            }
            return num == 1;
        }
    }
}
