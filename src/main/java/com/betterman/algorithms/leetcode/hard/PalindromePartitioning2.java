package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/16/16.
 */
public class PalindromePartitioning2 {
    public class Solution {
        public int minCut(String s) {
            char[] chs = s.toCharArray();
            int n = chs.length;
            int[] cut = new int[n + 1]; //the number of cuts for the first k characters
            for (int i = 0; i <= n; i++) {
                cut[i] = i - 1;
            }

            for (int i = 0; i < n; i++) {
                //odd length of palindrome
                //start from length 1 because cut[i-1] might just get updated
                for (int j = 0; i - j >= 0 && i + j < n && chs[i - j] == chs[i + j]; j++) {
                    cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
                }

                //even length of palindrome
                for (int j = 1; i - j + 1 >= 0 && i + j < n && chs[i - j + 1] == chs[i + j]; j++) {
                    cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
                }
            }
            return cut[n];
        }
    }
}
