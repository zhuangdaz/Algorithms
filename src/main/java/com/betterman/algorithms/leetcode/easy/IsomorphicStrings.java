package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhuangda on 1/10/16.
 */
public class IsomorphicStrings {
    public class Solution {
        //if string is using ASCII, we can use array instead of map.
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> map = new HashMap();
            Set<Character> set = new HashSet();
            char[] schs = s.toCharArray();
            char[] tchs = t.toCharArray();

            for (int i = 0; i < schs.length; i++) {
                if (map.containsKey(tchs[i])) {
                    if (map.get(tchs[i]) != schs[i]) return false;
                } else {
                    if (set.contains(schs[i])) return false;
                    else {
                        set.add(schs[i]);
                        map.put(tchs[i], schs[i]);
                    }
                }
            }
            return true;
        }

        public boolean isIsomorphicArray(String s, String t) {
            int[] m = new int[256 * 2];
            char[] schs = s.toCharArray();
            char[] tchs = t.toCharArray();

            for (int i = 0; i < schs.length; i++) {
                if (m[schs[i]] != m[tchs[i] + 256]) return false;

                m[schs[i]] = i + 1;
                m[tchs[i] + 256] = i + 1;
            }
            return true;
        }
    }
}
