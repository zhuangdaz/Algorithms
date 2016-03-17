package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/6/15.
 */
public class IntegerToRoman {
    public static class Solution {
        public String intToRoman(int num) {
            if (num > 3999 || num < 1) return null;
            char[][] table = new char[][]{
                    {'I', 'V', 'X'},
                    {'X', 'L', 'C'},
                    {'C', 'D', 'M'},
                    {'M', '*', '#'}
            };

            int i = 0;
            StringBuffer ret = new StringBuffer();
            while (num != 0) {
                int d = num % 10;

                if (d > 0) {
                    StringBuffer sec = new StringBuffer();
                    if (d == 4) {
                        sec.append(table[i][0]).append(table[i][1]);
                    } else if (d == 9) {
                        sec.append(table[i][0]).append(table[i][2]);
                    } else {
                        if (d / 5 == 1) {
                            sec.append(table[i][1]);
                            d %= 5;
                        }
                        while (d-- > 0) {
                            sec.append(table[i][0]);
                        }
                    }
                    ret.insert(0, sec);
                }

                num /= 10;
                i++;
            }

            return ret.toString();
        }

        public static final int[] intDict = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        public static final String[] romanDict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman2(int num) {
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (num > 0) {
                if (num >= intDict[i]) {
                    sb.append(romanDict[i]);
                    num -= intDict[i];
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
    }
}
