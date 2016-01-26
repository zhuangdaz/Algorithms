package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/25/16.
 */

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 * Show Tags
 */
public class DivideTwoIntegers {
    public static class Solution {
        //abs(MIN_VALUE) = abs(MAX_VALUE) + 1
        public int divide(int dividend, int divisor) {
            if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
                return Integer.MAX_VALUE;
            boolean neg = (dividend < 0) ^ (divisor < 0);
            long ldvd = Math.abs((long) dividend);
            long ldvs = Math.abs((long) divisor);
            int ret = 0;
            for (int bit = Integer.SIZE - 1; bit >= 0 && ldvd >= ldvs; bit--) {
                if (ldvd >= (ldvs << bit)) {
                    ret |= 1 << bit;
                    ldvd -= ldvs << bit;
                }
            }
            return neg ? -ret : ret;
        }

        public int divideBinarySearch(int dividend, int divisor) {
            if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
                return Integer.MAX_VALUE;
            boolean neg = (dividend < 0) ^ (divisor < 0);
            long ldvd = Math.abs((long) dividend);
            long ldvs = Math.abs((long) divisor);
            int ret = 0;

            int l = 0, r = Integer.SIZE - 1;
            while (ldvd >= ldvs) {
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (ldvd < (ldvs << mid)) {
                        r = mid - 1;
                    } else {
                        if (ldvd < (ldvs << (mid + 1))) {
                            ret |= 1 << mid;
                            ldvd -= ldvs << mid;
                            r = mid - 1;
                            l = 0;
                            break;
                        } else {
                            l = mid + 1;
                        }
                    }
                }
            }
            return neg ? -ret : ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);

        Solution solution = new Solution();
        System.out.println(solution.divideBinarySearch(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}
