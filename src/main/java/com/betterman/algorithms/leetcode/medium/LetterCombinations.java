package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/7/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinations {
    public class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList();
            if (digits.isEmpty()) return res;

            String[] table = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
            };

            helper(res, digits, "", table);
            return res;
        }

        private void helper(List<String> res, String left, String sofar, String[] table) {
            if (left.isEmpty()) {
                res.add(sofar);
                return;
            }

            int digit = left.charAt(0) - '0';
            char[] chars = table[digit].toCharArray();
            for (char c : chars) {
                helper(res, left.substring(1), sofar + c, table);
            }
            return;
        }
    }

}
