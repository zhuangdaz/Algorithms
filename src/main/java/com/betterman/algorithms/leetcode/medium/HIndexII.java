package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/8/16.
 */
public class HIndexII {
    public class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (citations[mid] == n - mid) return n - mid;
                else if (citations[mid] > n - mid) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return n - lo;
        }
    }
}
