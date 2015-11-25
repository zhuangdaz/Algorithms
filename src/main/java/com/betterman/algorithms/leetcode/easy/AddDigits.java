package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 11/24/15.
 */
public class AddDigits {
    public class Solution {
        public int addDigits(int num) {
            if (num == 0) return 0;

            if (num % 9 == 0)  return 9;
            else return num % 9;
        }
    }
}
