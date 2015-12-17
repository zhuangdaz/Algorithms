package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/17/15.
 */
public class DistinctSubseq {
    public class Solution {
        public int numDistinct(String s, String t) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            int m = sArr.length;
            int n = tArr.length;
            int[][] count = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                count[i][0] = 1;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (sArr[i - 1] == tArr[j - 1]) {
                        count[i][j] = count[i - 1][j - 1];
                    }

                    count[i][j] += count[i - 1][j]; //not include sArr[i - 1]
                }
            }
            return count[m][n];
        }
    }
}
