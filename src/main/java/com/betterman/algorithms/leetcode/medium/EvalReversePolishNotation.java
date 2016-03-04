package com.betterman.algorithms.leetcode.medium;

import java.util.Stack;

/**
 * Created by zhuangda on 3/4/16.
 */

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvalReversePolishNotation {
    public class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> s = new Stack();
            for (String token : tokens) {
                if (!isOperator(token)) {
                    s.push(Integer.valueOf(token));
                } else {
                    int op2 = s.pop();
                    int op1 = s.pop();
                    s.push(cal(op1, op2, token));
                }
            }
            return s.pop();
        }

        private boolean isOperator(String token) {
            return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
        }

        private int cal(int op1, int op2, String operator) {
            switch (operator) {
                case "+":
                    return op1 + op2;
                case "-":
                    return op1 - op2;
                case "*":
                    return op1 * op2;
                default:
                    return op1 / op2;
            }
        }
    }
}
