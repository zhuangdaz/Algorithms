package com.betterman.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 11/9/15.
 */

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without
 * using extra memory?
 */
public class SingleNumber {
    public class Solution {
        public int singleNumber(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }

            Set<Integer> processed = new HashSet();

            for (int num : nums) {
                if (processed.contains(num)) {
                    processed.remove(num);
                } else {
                    processed.add(num);
                }
            }

            return processed.iterator().next();
        }

        /**
         * Without extra space XOR of two equal numbers is 0 : a^a=0. This is the main idea of the
         * algorithm.
         */
        public int singleNumber2(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return 0;
            }

            for (int i = 1; i < nums.length; i++) {
                nums[0] ^= nums[i];
            }

            return nums[0];
        }
    }

    public static void main(String[] args) {

        System.out.println(6 ^ 3 ^ 6 ^ 3 ^ 2);
    }
}
