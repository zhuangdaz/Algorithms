package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/3/15.
 */
public class FlipGame {
    public class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> ret = new ArrayList();

            for (int i = 0; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c != '+' || s.charAt(i + 1) != '+') continue;

                String str = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                ret.add(str);
            }

            "".split(".");
            return ret;
        }
    }
}
