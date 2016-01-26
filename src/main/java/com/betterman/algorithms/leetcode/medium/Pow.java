package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/26/16.
 */
public class Pow {
    public class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;

            double tmp = myPow(x, n / 2);
            double tmpSqr = tmp * tmp;
            if (n % 2 == 0) return tmpSqr;
            else {
                return n > 0 ? tmpSqr * x : tmpSqr / x;
            }
        }
    }
}
