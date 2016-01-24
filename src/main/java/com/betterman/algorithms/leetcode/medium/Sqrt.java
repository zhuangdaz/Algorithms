package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/24/16.
 */
public class Sqrt {
    public class Solution {
        public int mySqrt(int n) {
            if (n <= 0) return 0;
            long r = n;
            while (r * r > n) {
                r = (r + n / r) >> 1;
            }
            return (int) r;
        }

        public int mySqrtBinarySearch(int n) {
            int l = 1, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mid > n / mid) {
                    r = mid - 1;
                } else {
                    if (mid + 1 > n / (mid + 1)) return mid;
                    l = mid + 1;
                }
            }
            return 0;
        }
    }
}
