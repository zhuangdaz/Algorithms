package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/8/15.
 */
public class ReverseWords {
    public static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            if (s.isEmpty()) return "";
            String[] words = s.split(" ");  //s.split("[ ]+"); takes more time.
            StringBuffer sb = new StringBuffer();
            for (int i = words.length - 1; i >= 0; i--) {
                if (!words[i].isEmpty()) { //critical check
                    sb.append(words[i]).append(" ");
                }
            }
            return sb.substring(0, sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseWords("  a  b"));
    }
}
