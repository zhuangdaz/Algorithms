package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/28/16.
 */
public class StrobogrammaticNumberIII {
    public class Solution {
        int count = 0;
        char[][] m = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

        public int strobogrammaticInRange(String low, String high) {
            for (int len = low.length(); len <= high.length(); len++) {
                dfs(new char[len], low, high, 0, len - 1);
            }
            return count;
        }

        private void dfs(char[] chs, String low, String high, int left, int right) {
            if (left > right) {
                String s = new String(chs);
                if (chs.length == low.length() && s.compareTo(low) < 0 ||
                        chs.length == high.length() && s.compareTo(high) > 0) {
                    return;
                }
                count++;
                return;
            }

            for (char[] p : m) {
                chs[left] = p[0];
                chs[right] = p[1];
                if (chs.length != 1 && chs[0] == '0') continue;
                if (left < right || p[0] == p[1]) dfs(chs, low, high, left + 1, right - 1);
            }
        }
    }
}
