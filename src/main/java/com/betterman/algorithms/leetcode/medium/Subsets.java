package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/31/15.
 */

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            res.add(new ArrayList());
            helper(res, nums, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, int[] nums, int i) {
            if (i == nums.length) return;
            List<List<Integer>> newLists = new ArrayList();
            for (List<Integer> list : res) {
                List<Integer> newList = new ArrayList(list);
                newList.add(nums[i]);
                newLists.add(newList);
            }
            res.addAll(newLists);
            helper(res, nums, i + 1);
        }

        public List<List<Integer>> subsetsBitManipulation(int[] nums) {
            Arrays.sort(nums);
            int totalNum = 1 << nums.length;
            List<List<Integer>> res = new ArrayList(totalNum);
            for (int i = 0; i < totalNum; i++) {
                List<Integer> set = new ArrayList();
                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) != 0) set.add(nums[j]);
                }
                res.add(set);
            }
            return res;
        }
    }
}
