package com.betterman.algorithms.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 3/1/16.
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
