package com.zhuangda.leetcode.hard;

/**
 * Created by zhuangda on 11/14/15.
 */
public class ValidNumber {
    /**
     rules:
     AeB代表A * 10 ^ B
     A可以是小数也可以是整数，可以带正负号
     .35, 00.神马的都算valid小数；就”.”单独一个不算
     B必须是整数，可以带正负号
     有e的话，A,B就必须同时存在
     */

    /**
     "0" => true
     " 0.1 " => true
     "abc" => false
     "1 a" => false
     "2e10" => true
     "+ 1" => false
     */

    /**
     * note: introduce Finite State Machine(http://blog.csdn.net/kenden23/article/details/18696083)
     */
    public static class Solution {
        enum InputType {
            INVALID,
            DIGIT,
            SIGN,
            EXP,
            SPACE,
            DOT
        }

        public boolean isNumber(String s) {
            if (s == null) return false;

            s = s.trim();

            int[][] transTable  = new int[][] {
                //0INV, 1DIG, 2SIG, 3EXP, 4SPA, 5DOT
                {  -1,   1,    6,    -1,   0,    2},
                {  -1,   1,    -1,   4,    -1,   3},
                {  -1,   3,    -1,   -1,   -1,   -1},
                {  -1,   3,    -1,   4,    -1,   -1},
                {  -1,   5,    7,    -1,   4,    -1},
                {  -1,   5,    -1,   -1,   -1,   -1},
                {  -1,   1,    -1,   -1,   -1,   2},
                {  -1,   5,    -1,   -1,   -1,   -1},

            };

            int state = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                InputType input = InputType.INVALID;
                if (c >= '0' && c <= '9') {
                    input = InputType.DIGIT;
                }
                else if (c == '+' || c == '-') {
                    input = InputType.SIGN;
                }
                else if (c == 'e' || c == 'E') {
                    input = InputType.EXP;
                }
                else if (c == ' ') {
                    input = InputType.SPACE;
                }
                else if (c == '.') {
                    input = InputType.DOT;
                }

                state = transTable[state][input.ordinal()];

                if (state == -1) {
                    return false;
                }
            }

            return state == 1 || state == 3 || state == 5;

        }
    }
}
