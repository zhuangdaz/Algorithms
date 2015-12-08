package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/8/15.
 */
public class GenerateParens {
    public class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList();
            if (n <= 0) return res;
            char[] sofar = new char[2 * n]; //always preallocate space if size is known
            helper(res, sofar, n, 0, 0);
            return res;
        }

        /**
         * @param left  available left parentheses
         * @param right available right parentheses
         * @param sofar current result
         * @param res   the answer list of the problem
         */
        private void helper(List<String> res, char[] sofar, int left, int right, int i) {
            if (left == 0 && right == 0) {
                res.add(new String(sofar));
                return;
            }

            if (left > 0) {
                sofar[i] = '(';
                helper(res, sofar, left - 1, right + 1, i + 1);
            }

            if (right > 0) {
                sofar[i] = ')';
                helper(res, sofar, left, right - 1, i + 1);
            }

            return;
        }
    }

}
