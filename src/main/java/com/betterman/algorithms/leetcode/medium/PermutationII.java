package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/27/15.
 */

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationII {
    //Same as Permutation problem,
    //we can use NextPermutation to solve this one to avoid worry about duplicates
    public static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            helper(nums, 0, res);
            return res;
        }

        //KEY: pass the copy of nums array to next recursion instead of reference,
        //otherwise, the order of the array is messed up when returns.
        private void helper(int[] nums, int start, List<List<Integer>> res) {
            if (start == nums.length - 1) {
                res.add(asList(nums));
            } else {
                for (int i = start; i < nums.length; i++) {
                    if (i != start && nums[i] == nums[start]) continue;
                    Utils.swap(nums, i, start);
                    helper(Arrays.copyOf(nums, nums.length), start + 1, res);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 0, 1, 9};
        System.out.println(solution.permuteUnique(nums));
    }
}
