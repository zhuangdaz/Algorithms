package com.betterman.algorithms.leetcode.easy;

import java.util.Arrays;

/**
 * Created by zhuangda on 12/21/15.
 */
public class MajorityElement {
    public class Solution {
        // Runtime:O(nlgn) - sorting
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2]; //the middle (n/2th) element must also be the majority element.
        }


        // Runtime:O(n) - Moore voting algorithm
        public int majorityElement2(int[] nums) {
            int major = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    major = nums[i];
                    count++;
                } else if (nums[i] == major) {
                    count++;
                } else {
                    count--;
                }
            }
            return major;
        }
    }
}
