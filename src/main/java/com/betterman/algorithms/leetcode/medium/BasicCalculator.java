package com.betterman.algorithms.leetcode.medium;

import java.util.Stack;

/**
 * Created by zhuangda on 1/24/16.
 */
public class BasicCalculator {
    public class Solution {
        public int calculate(String str) {
            int res = 0, sign = 1, num = 0;
            Stack<Integer> s = new Stack();
            s.push(sign);
            char[] chs = str.toCharArray();

            for (int i = 0; i < chs.length; i++) {
                if (chs[i] >= '0' && chs[i] <= '9') {
                    num = num * 10 + chs[i] - '0';
                } else if (chs[i] == '+' || chs[i] == '-') {
                    res += sign * num;
                    sign = s.peek() * (chs[i] == '+' ? 1 : -1);
                    num = 0;
                } else if (chs[i] == '(') {
                    s.push(sign);
                } else if (chs[i] == ')') {
                    s.pop();
                }
            }
            res += sign * num;
            return res;
        }
    }
}
