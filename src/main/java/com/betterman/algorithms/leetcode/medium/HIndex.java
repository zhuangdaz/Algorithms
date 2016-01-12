package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 1/11/16.
 */
public class HIndex {
    public class Solution {
        //O(nlgn)
        public int hIndexSort(int[] citations) {
            Arrays.sort(citations);
            int h = 0, n = citations.length;
            while (h + 1 <= n && citations[n - (h + 1)] >= h + 1) h++;
            return h;
        }

        //O(n)
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] m = new int[n + 1];
            for (int c : citations) {
                if (c > n) m[n]++;
                else m[c]++;
            }

            int h = n, count = m[n];
            while (h >= 0 && h > count) {
                h--;
                count += m[h];
            }
            return h;
        }
    }
}
