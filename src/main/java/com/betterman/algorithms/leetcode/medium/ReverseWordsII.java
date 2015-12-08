package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/7/15.
 */

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsII {
    public class Solution {
        public void reverseWords(char[] s) {
            if (s.length <= 2) return;

            reverseStr(s, 0, s.length - 1);
            int start = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == ' ') {
                    reverseStr(s, start, i - 1);
                    start = i + 1;
                }
            }

            reverseStr(s, start, s.length - 1);
        }

        private void reverseStr(char[] s, int l, int r) {
            if (l == r) return;

            while (l < r) {
                char tmp = s[l];
                s[l] = s[r];
                s[r] = tmp;
                l++;
                r--;
            }
        }
    }
}
