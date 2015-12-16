package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/15/15.
 */
public class RegexMatching {
    public static class Solution {
        public boolean isMatch(String s, String p) {
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            int m = sArr.length;
            int n = pArr.length;
            boolean[][] match = new boolean[m + 1][n + 1];

            match[0][0] = true;

            for (int i = 1; i <= n; i++) {
                if (pArr[i - 1] == '*' && match[0][i - 2]) {
                    match[0][i] = true;
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (pArr[j - 1] != '*') {
                        match[i][j] = match[i - 1][j - 1] && (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '.');
                    } else {
                        match[i][j] =
                            match[i][j - 2] ||   // for case * doesn't represent anything
                            (match[i - 1][j] && (sArr[i - 1] == pArr[j - 2] || pArr[j - 2] == '.')); // for case * represents one or more
                    }
                }
            }
            return match[m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abb";
        String p = ".*";
        solution.isMatch(s, p);
    }


}
