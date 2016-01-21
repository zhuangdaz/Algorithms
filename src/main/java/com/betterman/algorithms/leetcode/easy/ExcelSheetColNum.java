package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/21/16.
 */
public class ExcelSheetColNum {
    public class Solution {
        public int titleToNumber(String s) {
            int res = 0;
            char[] chs = s.toCharArray();
            for (char c : chs) {
                res = res * 26 + c - 'A' + 1;
            }
            return res;
        }
    }
}
