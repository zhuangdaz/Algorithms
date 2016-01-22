package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/21/16.
 */
public class FactorialTrailingZeroes {
    public class Solution {
        public int trailingZeroes(int n) {
            int num = 0;
            while (n > 0) {
                n /= 5;
                num += n;
            }
            return num;
        }
    }
}
