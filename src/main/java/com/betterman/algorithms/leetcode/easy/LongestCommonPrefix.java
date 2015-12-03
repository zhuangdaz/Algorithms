package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/2/15.
 */
public class LongestCommonPrefix {
    // time: O(mn)
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String longestPrefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                longestPrefix = commonPrefix(longestPrefix, strs[i]);
            }
            return longestPrefix;
        }

        private String commonPrefix(String str1, String str2) {
            int i = 0;
            while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
                i++;
            }
            return str1.substring(0, i);
        }
    }
}
