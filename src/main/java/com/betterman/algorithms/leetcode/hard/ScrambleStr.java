package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/16/15.
 */
public class ScrambleStr {
    public static class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) return true;
            int[] count = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }

            for (int num : count) {
                if (num != 0) return false;
            }

            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ab";
        String s2 = "ba";

        solution.isScramble(s1, s2);
    }
}
