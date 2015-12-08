package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/8/15.
 */

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    public class Solution {

        // case: ab, a; ba, a
        public boolean isOneEditDistance(String s, String t) {
            if (s.length() < t.length()) return isOneEditDistance(t, s);

            if (s.equals(t)) return false;

            if (s.length() - t.length() > 1) return false;
            int i = 0;
            while (i < s.length() - 1 && s.charAt(i) == t.charAt(i)) i++;

            if (i == s.length() - 1) return true;

            if (s.substring(i + 1).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i))) return true;
            else return false;
        }
    }
}
