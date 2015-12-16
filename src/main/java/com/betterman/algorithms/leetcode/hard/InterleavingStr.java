package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/15/15.
 */
public class InterleavingStr {
    public static class Solution {
        //Time limit exceeded
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) return false;

            return helper(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
        }

        private boolean helper(char[] chars1, int i1, char[] chars2, int i2, char[] chars3, int i3) {
            if (i3 == chars3.length) return true;

            if (i1 == chars1.length || i2 == chars2.length) return false;

            if (chars1[i1] == chars3[i3] && helper(chars1, i1 + 1, chars2, i2, chars3, i3 + 1)) {
                return true;
            }

            if (chars2[i2] == chars3[i3] && helper(chars1, i1, chars2, i2 + 1, chars3, i3 + 1)) {
                return true;
            }

            return false;
        }

        public boolean isInterleaveDP(String s1, String s2, String s3) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] chars3 = s3.toCharArray();

            int m = chars1.length;
            int n = chars2.length;

            if (m + n != chars3.length) return false;

            boolean[][] t = new boolean[m + 1][n + 1];

            t[0][0] = true;

            for (int i = 1; i <= m; i++) {
                t[i][0] = t[i - 1][0] && chars1[i - 1] == chars3[i - 1];
            }

            for (int i = 1; i <= n; i++) {
                t[0][i] = t[0][i - 1] && chars2[i - 1] == chars3[i - 1];
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    t[i][j] = (t[i - 1][j] && chars1[i - 1] == chars3[i + j - 1]) ||
                        (t[i][j - 1] && chars2[j - 1] == chars3[i + j - 1]);
                }
            }
            return t[m][n];
        }


        //space: O(n); time: O(mn)
        public boolean isInterleaveSpaceOptimal(String s1, String s2, String s3) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] chars3 = s3.toCharArray();

            int m = chars1.length;
            int n = chars2.length;

            if (m + n != chars3.length) return false;

            boolean[] opt = new boolean[n + 1];
            opt[0] = true;

            for (int i = 0; i < n; i++) {
                opt[i + 1] = opt[i] && chars2[i] == chars3[i];
            }

            for (int i = 0; i < m; i++) {
                opt[0] = opt[0] && chars1[i] == chars3[i];
                for (int j = 0; j < n; j++) {
                    opt[j + 1] = opt[j + 1] && chars1[i] == chars3[i + j + 1] ||
                        opt[j] && chars2[j] == chars3[i + j + 1];
                }
            }
            return opt[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
        String s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
        String s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";

        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
