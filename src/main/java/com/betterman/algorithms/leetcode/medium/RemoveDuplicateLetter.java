package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/4/16.
 */

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every
 * letter appear once and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 *
 * Example: Given "bcabc" Return "abc"
 *
 * Given "cbacdcbc" Return "acdb"
 */
public class RemoveDuplicateLetter {
    public class Solution {
        // O(n)
        public String removeDuplicateLetters(String s) {
            int[] cnt = new int[26];
            char[] chs = s.toCharArray();
            for (char c : chs) {
                cnt[c - 'a']++;
            }

            char[] stack = new char[26];
            boolean[] inRes = new boolean[26];
            int i = -1;

            for (char c : chs) {
                cnt[c - 'a']--;
                if (inRes[c - 'a']) {
                    continue;
                }

                while (i >= 0 && stack[i] > c && cnt[stack[i] - 'a'] > 0) {
                    inRes[stack[i] - 'a'] = false;
                    i--;

                }

                stack[++i] = c;
                inRes[c - 'a'] = true;
            }

            return String.valueOf(stack).substring(0, i + 1);
        }
    }
}
