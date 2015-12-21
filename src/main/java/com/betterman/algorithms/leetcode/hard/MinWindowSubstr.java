package com.betterman.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhuangda on 12/20/15.
 */
public class MinWindowSubstr {
    public class Solution {
        // with amortized analysis, every character at most iterated twice,
        // so that time complexity is O(2n)
        public String minWindow(String s, String t) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            if (sArr.length < tArr.length) return "";

            Map<Character, Integer> map = new HashMap();
            for (char c : tArr) {
                if (!map.containsKey(c)) {
                    map.put(c, 0);
                }
                map.put(c, map.get(c) + 1);
            }

            int count = tArr.length;
            int begin = 0, end = 0;
            int minIdx = -1, minDist = Integer.MAX_VALUE;

            while (end < sArr.length) {
                char c = sArr[end++];
                if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        count--;
                    }
                    map.put(c, map.get(c) - 1);
                }

                //substring is valid
                while (count == 0) {
                    //[begin, end)
                    if (end - begin < minDist) {
                        minDist = end - begin;
                        minIdx = begin;
                    }

                    //shrink the window and try to make the substring invalid
                    char beginChar = sArr[begin++];
                    if (map.containsKey(beginChar)) {
                        map.put(beginChar, map.get(beginChar) + 1);
                        if (map.get(beginChar) > 0) {
                            count++;
                        }
                    }
                }
            }
            return minDist == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minDist);
        }

        //Use fixed size array instead of hash table, increase performance
        public String minWindowFixedArray(String s, String t) {
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            if (sArr.length < tArr.length) return "";

            int[] map = new int[128]; //ASCII table
            for (char c : tArr) {
                map[c]++;
            }

            int count = tArr.length;
            int begin = 0, end = 0;
            int minIdx = -1, minDist = Integer.MAX_VALUE;

            while (end < sArr.length) {
                if (map[sArr[end++]]-- > 0) count--;

                //substring is valid
                while(count == 0) {
                    //[begin, end)
                    if (end - begin < minDist) {
                        minDist = end - begin;
                        minIdx = begin;
                    }

                    //shrink the window and try to make the substring invalid
                    if (map[sArr[begin++]]++ == 0) count++;
                }
            }

            return minDist == Integer.MAX_VALUE ? "" : s.substring(minIdx, minIdx + minDist);
        }
    }
}
