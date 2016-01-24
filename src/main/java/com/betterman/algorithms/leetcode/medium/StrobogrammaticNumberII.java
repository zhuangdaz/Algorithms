package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 1/24/16.
 */
public class StrobogrammaticNumberII {
    public class Solution {
        public List<String> findStrobogrammatic(int n) {
            return helper(n, n);
        }

        private List<String> helper(int m, int n) {
            if (m == 0) return new ArrayList(Arrays.asList(""));
            if (m == 1) return new ArrayList(Arrays.asList("0", "1", "8"));

            List<String> list = helper(m - 2, n);
            List<String> res = new ArrayList();

            for (String s : list) {
                if (m != n) res.add("0" + s + "0");

                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }
            return res;
        }
    }
}
