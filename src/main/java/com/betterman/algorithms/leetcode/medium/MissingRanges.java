package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/28/15.
 */
public class MissingRanges {
    public class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            int rangeLo = lower;
            List<String> res = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > rangeLo) {
                    res.add(getRange(rangeLo, nums[i] - 1));
                }
                rangeLo = nums[i] + 1;
            }

            if (rangeLo <= upper) {
                res.add(getRange(rangeLo, upper));
            }
            return res;
        }


        private String getRange(int start, int end) {
            StringBuffer sb = new StringBuffer(String.valueOf(start));
            return start == end ? sb.toString() : sb.append("->").append(end).toString();
        }
    }
}
