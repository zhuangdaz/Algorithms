package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/26/15.
 */
public class FourSum {
    public class Solution {
        //O(n ^ 3)
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                int target3 = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int lo = j + 1, hi = nums.length - 1;
                    int target2 = target3 - nums[j];
                    while (lo < hi) {
                        int twoSum = nums[lo] + nums[hi];
                        if (twoSum < target2) lo++;
                        else if (twoSum > target2) hi--;
                        else {
                            List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]);
                            res.add(quadruplet);

                            while (lo < hi && nums[lo] == quadruplet.get(2)) lo++;
                            while (lo < hi && nums[hi] == quadruplet.get(3)) hi--;
                        }
                    }

                    while (j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
                }

                while (i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
            }
            return res;
        }
    }
}
