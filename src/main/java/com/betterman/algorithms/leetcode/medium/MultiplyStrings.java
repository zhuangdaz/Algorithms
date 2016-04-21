package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/7/15.
 */

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings {
    public static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();

            int[] ret = new int[chars1.length + chars2.length];

            for (int i = chars2.length - 1; i >= 0; i--) {
                int mc = chars2[i] - '0';
                if (mc == 0) continue;
                int c = 0;
                int indexInRet = ret.length - 1 - (chars2.length - 1 - i);
                for (int j = chars1.length - 1; j >= 0; j--, indexInRet--) {
                    int m = chars1[j] - '0';
                    int result = m * mc + c + ret[indexInRet];
                    ret[indexInRet] = result % 10;
                    c = result / 10;
                }

                while (c != 0) {
                    int sum = ret[indexInRet] + c;
                    ret[indexInRet] = sum % 10;
                    c = sum / 10;
                    indexInRet--;
                }
            }

            StringBuffer sb = new StringBuffer();
            boolean isHead = true;
            for (int i : ret) {
                if (i == 0 && isHead) continue;

                isHead = false;
                sb.append(i);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "23";
        String s2 = "20";
        System.out.println(solution.multiply(s1, s2));
    }
}
