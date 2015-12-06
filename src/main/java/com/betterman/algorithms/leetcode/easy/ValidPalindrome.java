package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/4/15.
 */
public class ValidPalindrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) return false;
            s = s.trim().toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            char[] chars = s.toCharArray();
            while (i < j) {
                while (i < j && !isAlphanumeric(chars[i])) {
                    i++;
                }

                while (i < j && !isAlphanumeric(chars[j])) {
                    j--;
                }

                if (i >= j) return true;

                if (chars[i] != chars[j]) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
            return true;
        }

        private boolean isAlphanumeric(char c) {
            if (c >= 'a' && c <= 'z') return true;

            if (c >= '0' && c <= '9') return true;

            return false;
        }
    }
}
