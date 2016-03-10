package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/9/16.
 */
public class MaxProdOfWordLenghts {
    public class Solution {
        public int maxProduct(String[] words) {
            int max = 0;
            int[] masks = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                char[] chs = words[i].toCharArray();
                int mask = 0;
                for (char c : chs) {
                    mask |= 1 << (c - 'a');
                }
                masks[i] = mask;
                for (int j = 0; j < i; j++) {
                    if ((masks[j] & masks[i]) == 0) {
                        max = Math.max(max, words[j].length() * words[i].length());
                    }
                }
            }
            return max;
        }

    }
}
