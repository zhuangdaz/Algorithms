package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 1/11/16.
 */
public class HIndex {
    public class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int h = 0, n = citations.length;
            while (h + 1 <= n && citations[n - (h + 1)] >= h + 1) h++;
            return h;
        }
    }
}
