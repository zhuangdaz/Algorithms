package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/21/16.
 */
public class PowerOfTwo {
    public class Solution {
        // If n is power of two, it has only one "1" bit.
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }
    }
}
