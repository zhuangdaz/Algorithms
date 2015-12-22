package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/21/15.
 */
public class SummaryRanges {
    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList();

            for (int i = 0, w; i < nums.length; i = w) {
                for (w = i + 1; w < nums.length && nums[w] == nums[w - 1] + 1; w++) ;

                StringBuffer sb = new StringBuffer("" + nums[i]);
                if (w - 1 > i) {
                    sb.append("->");
                    sb.append(nums[w - 1]);
                }
                res.add(sb.toString());
            }
            return res;
        }
    }
}
