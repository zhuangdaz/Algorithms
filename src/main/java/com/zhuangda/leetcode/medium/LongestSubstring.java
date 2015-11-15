package com.zhuangda.leetcode.medium;

import java.util.HashMap;

/**
 * Created by zhuangda on 10/11/15.
 */
public class LongestSubstring {
    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap();
            int lastCharLength = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!map.containsKey(c) || map.get(c) <= i - 1 - lastCharLength) {
                    lastCharLength++;
                } else {
                    int lastPresent = map.get(c);
                    lastCharLength = i - lastPresent;
                }

                map.put(c, i);

                if (lastCharLength > max) {
                    max = lastCharLength;
                }
            }
            return max;
        }

        // Essence(two pointers, hashMap):
        // 1. find every character's start point(inclusive),
        // 2. each character's start point at least starts from last character's start point
        public int lengthOfLongestSubstringSimpler(String s) {
            if (s == null) {
                return 0;
            }

            HashMap<Character, Integer> map = new HashMap();
            int start = 0;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                start = Math.max(start, map.containsKey(c) ? map.get(c) + 1 : 0);

                max = Math.max(max, i - start + 1);

                map.put(c, i);
            }
            return max;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        List<Pair<String, Integer>> pairs =
//        Pair<String, Integer> pair;
//    }
}
