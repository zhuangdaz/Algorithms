package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/4/15.
 */
public class LengthLastWord {
    public class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null) return 0;
            s = s.trim();

            int n = s.length();
            char[] chars = s.toCharArray();
            while (--n >= 0) {
                if (chars[n] == ' ') {
                    return s.length() - 1 - n;
                }
            }
            return s.length();
        }
    }
}
