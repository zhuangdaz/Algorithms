package com.betterman.algorithms.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 3/1/16.
 */

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a
 * non-empty substring in str.
 *
 * Examples: pattern = "abab", str = "redblueredblue" should return true. pattern = "aaaa", str =
 * "asdasdasdasd" should return true. pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes: You may assume both pattern and str contains only lowercase letters.
 */

public class WordPatternII {
    public class Solution {
        public boolean wordPatternMatch(String pattern, String str) {
            String[] map = new String[26];
            return dfs(pattern, 0, str, 0, map, new HashSet());
        }

        boolean dfs(String pattern, int pi, String str, int si, String[] map, Set<String> mem) {
            if (pi == pattern.length() && si == str.length()) return true;
            if (pi == pattern.length() || si == str.length()) return false;


            char c = pattern.charAt(pi);
            if (map[c - 'a'] != null) {
                String match = map[c - 'a'];
                if (!str.startsWith(match, si)) {
                    return false;
                } else {
                    return dfs(pattern, pi + 1, str, si + match.length(), map, mem);
                }
            } else {
                for (int i = si; i < str.length(); i++) {
                    String match = str.substring(si, i + 1);
                    if (mem.contains(match)) continue;
                    else mem.add(match);
                    map[c - 'a'] = match;
                    if (dfs(pattern, pi + 1, str, i + 1, map, mem)) return true;
                    map[c - 'a'] = null;
                    mem.remove(match);
                }
                return false;
            }
        }
    }
}
