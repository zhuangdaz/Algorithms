package com.betterman.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 12/20/15.
 */
public class MinWindowSubstr {
    public static class Solution {
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
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) >= 0) {
                        count--;
                    }
                }

                while (count == 0) {
                    if (end - begin < minDist) {
                        minDist = end - begin;
                        minIdx = begin;
                    }

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
    }
}
