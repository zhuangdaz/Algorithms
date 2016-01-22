package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/21/16.
 */
public class ExcelSheetColumnTitle {
    public class Solution {
        public String convertToTitle(int n) {
            StringBuffer sb = new StringBuffer();
            while (n > 0) {
                n--;
                sb.append((char) ('A' + n % 26));
                n /= 26;
            }
            return sb.reverse().toString();
        }
    }
}
