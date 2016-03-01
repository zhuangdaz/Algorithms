package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/29/16.
 */
public class GrayCode {
    public class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList();
            int max = 1 << n;
            for (int i = 0; i < max; i++) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }
    }
}
