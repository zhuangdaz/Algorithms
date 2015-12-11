package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 12/10/15.
 */
public class LongestSubStrTwoDistinct {
    public class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            if (s.isEmpty()) return 0;
            int max = 1;
            int p1 = 0, p2 = 0;
            int last = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (p1 != p2 && chars[i] != chars[p1] && chars[i] != chars[p2]) {
                    if (last > max) max = last;

                    last = i - p1;
                    p1 = p2;
                    p2 = i;
                } else {
                    if (chars[i] == chars[p1]) {
                        p1 = p1 == p2 ? i : p2;
                    }
                    last++;
                    p2 = i;
                }
            }

            if (last > max) max = last;
            return max;
        }
    }
}
