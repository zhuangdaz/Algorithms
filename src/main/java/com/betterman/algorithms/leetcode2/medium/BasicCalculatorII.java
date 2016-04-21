package com.betterman.algorithms.leetcode2.medium;

/**
 * Created by zhuangda on 3/17/16.
 */
public class BasicCalculatorII {
    public class Solution {
        public int calculate(String s) {
            int ans = 0;
            int preNum = 0, num = 0;
            char lastOpt = '+';
            char[] chars = s.trim().toCharArray();
            for (int i = 0; i <= chars.length; i++) {
                char c = i != chars.length ? chars[i] : '+';
                if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                } else if (c != ' ') {
                    if (lastOpt == '+' || lastOpt == '-') {
                        ans += preNum;
                        preNum = lastOpt == '-' ? -num : num;
                    } else if (lastOpt == '*') {
                        preNum *= num;
                    } else {
                        preNum /= num;
                    }
                    lastOpt = c;
                    num = 0;
                }
            }
            ans += preNum;
            return ans;
        }
    }
}
