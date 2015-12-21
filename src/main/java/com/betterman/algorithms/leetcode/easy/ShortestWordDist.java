package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/20/15.
 */

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * <p>
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDist {
    public class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            int min = Integer.MAX_VALUE, lastIdx1 = -1, lastIdx2 = -1;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word1.equals(word)) {
                    lastIdx1 = i;
                } else if (word2.equals(word)) {
                    lastIdx2 = i;
                } else {
                    continue;
                }

                if (lastIdx1 != -1 && lastIdx2 != -1) {
                    min = Math.min(min, Math.abs(lastIdx1 - lastIdx2));
                }
            }
            return min;
        }
    }
}
