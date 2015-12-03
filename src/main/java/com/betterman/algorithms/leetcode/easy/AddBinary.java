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
                carry = sum / 2;
                sb.insert(0, sum % 2);
            }
            return sb.toString();
        }
    }
}
