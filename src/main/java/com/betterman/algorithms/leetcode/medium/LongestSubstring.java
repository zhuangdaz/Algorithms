package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 10/11/15.
 */

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstring {
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int lastMax = 0;
            int[] m = new int[256];
            for (int i = 0; i < m.length; i++) m[i] = -1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (m[c] < i - lastMax) {
                    lastMax++;
                    if (lastMax > max) max = lastMax;
                } else {
                    lastMax = i - m[c];
                }
                m[c] = i;
            }

            return max;
        }
    }
}
