package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/2/15.
 */
public class AddBinary {
    public class Solution {
        public String addBinary(String a, String b) {
            StringBuffer sb = new StringBuffer();
            int carry = 0;
            int lenA = a.length();
            int lenB = b.length();
            for (int i = 0; i < lenA || i < lenB || carry > 0; i++) {
                int x = i < lenA && a.charAt(lenA - 1 - i) == '1' ? 1 : 0;
                int y = i < lenB && b.charAt(lenB - 1 - i) == '1' ? 1 : 0;

                int sum = x + y + carry;
                if (sum == 0) {
                    sb.insert(0, "0");
                    carry = 0;
                } else if (sum == 1) {
                    sb.insert(0, "1");
                    carry = 0;
                } else if (sum == 2) {
                    sb.insert(0, "0");
                    carry = 1;
                } else {
                    sb.insert(0, "1");
                    carry = 1;
                }
            }
            if (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
            return sb.toString();
        }
    }
}
