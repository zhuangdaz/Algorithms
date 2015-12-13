package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/11/15.
 */
public class WildcardMatching {
    public static class Solution {
        //DP:Top down
        public boolean isMatch(String s, String p) {
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            int m = s.length();
            int n = p.length();
            boolean[][] match = new boolean[m + 1][n + 1];
            match[0][0] = true;
            for (int i = 1; i < n + 1; i++) {
                if (pArr[i - 1] == '*' && match[0][i - 1]) {
                    match[0][i] = true;
                }
            }


            for (int j = 1; j < n + 1; j++) {
                for (int i = 1; i < m + 1; i++) {
                    if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '?') {
                        match[i][j] = match[i - 1][j - 1];
                    } else if (pArr[j - 1] == '*') {
                        match[i][j] = match[i - 1][j - 1] || match[i][j - 1] || match[i - 1][j];
                    }
                }
            }
            return match[m][n];
        }

        public boolean isMatchGreedy(String s, String p) {
            //greedy: try to move forward as fast as possible
            //backtracking: once encountering mismatch, come back to last astroid to match one more character
            char[] sArr = s.toCharArray();
            char[] pArr = p.toCharArray();
            int sIdx = 0, pIdx = 0, astIdx = -1, matched = -1;
            while (sIdx < sArr.length) {
                if (pIdx < pArr.length && (pArr[pIdx] == '?' || sArr[sIdx] == pArr[pIdx])) {
                    sIdx++;
                    pIdx++;
                } else if (pIdx < pArr.length && pArr[pIdx] == '*') {
                    astIdx = pIdx;
                    matched = sIdx - 1;
                    pIdx++;
                } else if (astIdx != -1) {
                    matched++;
                    pIdx = astIdx + 1;
                    sIdx = matched + 1;
                } else {
                    return false;
                }
            }

            while (pIdx < pArr.length) {
                if (pArr[pIdx++] != '*') return false;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // "", "*"
        // "ab", "*a"
        solution.isMatchGreedy("ab", "*a");
    }
}
