package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.Utils;

/**
 * Created by zhuangda on 12/27/15.
 */
public class NextPermutation {
    public class Solution {

        //O(n)
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            for (; i >= 0 && nums[i] >= nums[i + 1]; i--);

            if (i > -1) {
                int j = nums.length - 1;
                for (; nums[j] <= nums[i]; j--);
                Utils.swap(nums, i, j);
                Utils.reverse(nums, i + 1, nums.length - 1);
            } else {
                Utils.reverse(nums, 0, nums.length - 1);
            }
        }
    }
}
