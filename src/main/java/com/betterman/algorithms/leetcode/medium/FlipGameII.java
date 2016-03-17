package com.betterman.algorithms.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 2/28/16.
 */
public class FlipGameII {
    public class Solution {
        //there is at most 2^n to transform the original string.
        //since already processed cases are in map, so that time complexity: O(2^n)
        public boolean canWin(String s) {
            return canWin(s, new HashMap());
        }

        private boolean canWin(String s, Map<String, Boolean> mem) {
            if (mem.containsKey(s)) return mem.get(s);

            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) != '+' || s.charAt(i + 1) != '+') continue;

                String next = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(next, mem)) {
                    mem.put(s, true);
                    return true;
                }
            }
            mem.put(s, false);
            return false;
        }

    }
}
