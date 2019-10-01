package com.betterman.algorithms.leetcode3.array;

import java.util.Arrays;

/**
 * Created by zhuangda on 7/18/17.
 */
public class ArrayPartitionI {
    public class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                sum += nums[2 * i];
            }
            return sum;
        }
    }
}
