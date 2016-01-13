package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuangda on 1/13/16.
 */

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 * <p>
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
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
public class ShortestWordDistanceII {
    public class WordDistance {
        Map<String, List<Integer>> map = new HashMap();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                map.putIfAbsent(word, new ArrayList());
                map.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int min = Integer.MAX_VALUE;
            List<Integer> index1 = map.get(word1);
            List<Integer> index2 = map.get(word2);

            //O(m + n)
            for (int i = 0, j = 0; i < index1.size() && j < index2.size(); ) {
                int i1 = index1.get(i);
                int i2 = index2.get(j);
                int dist = Math.abs(i1 - i2);
                if (dist < min) min = dist;
                if (i1 < i2) i++;
                else j++;
            }
            return min;
        }
    }

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
}
