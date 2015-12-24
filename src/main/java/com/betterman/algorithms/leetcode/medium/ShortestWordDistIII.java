package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/24/15.
 */
public class ShortestWordDistIII {
    public class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            int p1 = Integer.MAX_VALUE / 2;
            int p2 = -Integer.MAX_VALUE / 2;
            int min = Integer.MAX_VALUE;

            boolean sameWord = word1.equals(word2);
            for (int i = 0; i < words.length; i++) {
                String word = words[i];

                if (word.equals(word1)) {
                    if (sameWord) {
                        p2 = p1;
                    }
                    p1 = i;
                } else if (word.equals(word2)) {
                    p2 = i;
                } else continue;

                min = Math.min(min, Math.abs(p1 - p2));
            }
            return min;
        }
    }
}
