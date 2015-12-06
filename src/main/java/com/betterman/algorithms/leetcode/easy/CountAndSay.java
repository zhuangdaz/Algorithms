package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/4/15.
 */
public class CountAndSay {
    public class Solution {
        public String countAndSay(int n) {
            if (n <= 0) return null;
            String ret = "1";
            for (int i = 1; i < n; i++) {
                char[] chars = ret.toCharArray();  //char array is faster than charAt().
                StringBuffer sb = new StringBuffer();
                int j = 0;
                while (j < chars.length) {
                    int count = 1;
                    while (j + count < chars.length && chars[j + count] == chars[j]) count++;
                    sb.append(count);
                    sb.append(chars[j]);

                    j += count;
                }
                ret = sb.toString();
            }
            return ret;
        }
    }


}
