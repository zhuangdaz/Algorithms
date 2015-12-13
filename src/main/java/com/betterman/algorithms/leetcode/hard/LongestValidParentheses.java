package com.betterman.algorithms.leetcode.hard;

import java.util.Stack;

/**
 * Created by zhuangda on 12/13/15.
 */
public class LongestValidParentheses {
    public static class Solution {
        public int longestValidParentheses(String s) {
            int max = 0, start = 0;
            Stack<Integer> stack = new Stack();
            char[] sArr = s.toCharArray();
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {
                        start = i + 1;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            max = Math.max(max, i - start + 1); //case: ()()
                        } else {
                            max = Math.max(max, i - stack.peek());  //case: (()()
                        }
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s =
            ""
            ;
        solution.longestValidParentheses();
    }
}
