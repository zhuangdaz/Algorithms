package com.zhuangda.leetcode.easy;

/**
 * Created by zhuangda on 10/16/15.
 */
public class ZigZag {
    public class Solution {
        public String convert(String s, int numRows) {
            if (s == null || s.length() == 0 || numRows <= 0) {
                return "";
            }

            StringBuffer[] sbs = new StringBuffer[numRows];
            for (int i = 0; i < numRows; i++) {
                sbs[i] = new StringBuffer();
            }

            int i = 0;
            while (i < s.length()) {
                for (int j = 0; j < numRows && i < s.length(); j++) {
                    sbs[j].append(s.charAt(i++));
                }

                for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                    sbs[j].append(s.charAt(i++));
                }
            }

            for (int row = 1; row < numRows; row++) {
                sbs[0].append(sbs[row]);
            }

            return sbs[0].toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
