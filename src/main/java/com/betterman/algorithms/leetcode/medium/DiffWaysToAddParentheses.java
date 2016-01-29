package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 1/29/16.
 */
public class DiffWaysToAddParentheses {
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> res = new ArrayList();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '+' || c == '-' || c == '*') {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));

                    for (int num1 : left) {
                        for (int num2 : right) {
                            int val = 0;
                            switch (c) {
                                case '+':
                                    val = num1 + num2;
                                    break;
                                case '-':
                                    val = num1 - num2;
                                    break;
                                case '*':
                                    val = num1 * num2;
                                    break;
                            }
                            res.add(val);
                        }
                    }
                }
            }

            if (res.isEmpty()) {
                res.add(new Integer(input));
            }
            return res;
        }
    }
}
