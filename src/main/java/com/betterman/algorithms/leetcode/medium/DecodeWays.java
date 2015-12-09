package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/8/15.
 */


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 * <p>
 * Hide Company Tags Facebook
 * Hide Tags Dynamic Programming String
 */
public class DecodeWays {
    public class Solution {
        public int numDecodings(String s) {
            // empty string or leading zero string means no way
            if (s.isEmpty() || s.charAt(0) == '0') return 0;
            // Critical: r1 and r2 store ways of the last and the last of the last
            int r1 = 1, r2 = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                int d = chars[i] - '0';
                int lastD = chars[i - 1] - '0';

                //case: 50
                if (d == 0) r1 = 0;

                //case: 123
                if (lastD > 0 && lastD * 10 + d <= 26) {
                    int tmp = r1;
                    r1 = r1 + r2;
                    r2 = tmp;
                } else {
                    r2 = r1;
                }
            }
            return r1;
        }
    }
}
