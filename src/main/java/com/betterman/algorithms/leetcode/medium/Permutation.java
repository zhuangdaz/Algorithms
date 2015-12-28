package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/27/15.
 */
public class Permutation {
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList();
            helper(nums, 0, res);
            return res;
        }

        private void helper(int[] nums, int start, List<List<Integer>> res) {
            if (start == nums.length) {
                res.add(asList(nums));
            }
            else {
                for (int i = start; i < nums.length; i++) {
                    Utils.swap(nums, i, start);
                    helper(nums, start + 1, res);
                    Utils.swap(nums, i, start);
                }
            }
        }

        private List<Integer> asList(int[] nums) {
            List<Integer> list = new ArrayList();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }
    }
}
