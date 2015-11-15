package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 10/17/15.
 */
public class ReverseInteger {
    public static class Solution {
        public int reverse(int x) {
            // corner case: 10, overflow
            // Integer.MAX_VALUE = 2147483647
            // Integer.MIN_VALUE = -2147483648
            // spoiler: can we use long?
            // For java, mod calculation: a%b=a-(a/b)*b
            if (x == Integer.MIN_VALUE) {
                return 0;
            }

            if (x < 0) {
                x = Math.abs(x);
                return -1 * reverse(x);
            }

            int ret = 0;

            while (x != 0) {
                ret = ret * 10 + x % 10;
                x /= 10;

                if (ret > 214748364 && x != 0) {
                    return 0;  //overflow
                }
            }

            return ret;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(Integer.MIN_VALUE));

        int val = -11;
        System.out.println(val % 10);
        System.out.println(val / 10);
    }
}
