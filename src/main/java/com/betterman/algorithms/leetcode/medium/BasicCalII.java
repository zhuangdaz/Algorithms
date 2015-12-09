package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuangda on 12/6/15.
 */
public class BasicCalII {
    public static class Solution {
        public int calculate(String s) {
            List<Integer> ints = new ArrayList();
            List<Character> opts = new ArrayList();

            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char c : chars) {
                if (c >= '0' && c <= '9') {
                    sb.append(c);
                } else {
                    if (c != ' ') {
                        opts.add(c);
                    }
                    if (sb.length() != 0) {
                        ints.add(new Integer(sb.toString()));
                        sb = new StringBuffer();
                    }
                }
            }
            if (sb.length() != 0) {
                ints.add(new Integer(sb.toString()));
            }

            Iterator<Character> iter = opts.iterator();
            int i = 0;
            while (iter.hasNext()) {
                Character opt = iter.next();
                if (opt == '*' || opt == '/') {
                    int result;
                    if (opt == '*') {
                        result = ints.get(i) * ints.get(i + 1);
                    } else {
                        result = ints.get(i) / ints.get(i + 1);
                    }
                    ints.remove(i + 1);
                    ints.remove(i);
                    ints.add(i, result);
                    iter.remove();
                } else {
                    i++;
                }
            }

            for (Character opt : opts) {
                int result;
                if (opt == '+') {
                    result = ints.get(0) + ints.get(1);
                } else {
                    result = ints.get(0) - ints.get(1);
                }
                ints.remove(1);
                ints.remove(0);
                ints.add(0, result);
            }
            return ints.get(0);
        }

        // one loop, O(n) time and O(1) space
        public int calculate2(String s) {
            int res = 0, preNum = 0, num = 0;
            char opt = 0;

            char[] chars = s.trim().toCharArray();
            for (int i = 0; i <= chars.length; i++) {
                char c = i < chars.length ? chars[i] : 0; //if reaches end of string, assign 0 to c
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                } else if (c != ' ') {
                    if (opt == 0 || opt == '+' || opt == '-') {
                        res += preNum;
                        num = opt == '-' ? -1 * num : num;
                        preNum = num;
                    } else if (opt == '*') {
                        preNum *= num;
                    } else {
                        preNum /= num;
                    }
                    opt = c;
                    num = 0;
                }
            }

            res += preNum;

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String in =
            " 3+5 / 2 ";
        System.out.println(
            solution.calculate(
                in
            )
        );

    }
}
