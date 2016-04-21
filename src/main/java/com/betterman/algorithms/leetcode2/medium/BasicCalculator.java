package com.betterman.algorithms.leetcode2.medium;

import java.util.Stack;

/**
 * Created by zhuangda on 3/17/16.
 */
public class BasicCalculator {
    public class Solution {
        public int calculate(String s) {
            Stack<Integer> contexts = new Stack();
            contexts.push(1);
            int ans = 0, num = 0, sign = 1;
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else if (c == '+') {
                    ans += sign * num;
                    sign = contexts.peek();
                    num = 0;
                } else if (c == '-') {
                    ans += sign * num;
                    sign = -contexts.peek();
                    num = 0;
                } else if (c == '(') {
                    contexts.push(sign);
                } else if (c == ')') {
                    contexts.pop();
                }
            }
            ans += sign * num;
            return ans;
        }

    }
}
