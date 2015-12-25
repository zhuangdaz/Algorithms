package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 12/24/15.
 */
public class WiggleSort {
    public class Solution {

        // O(nlgn)
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);

            for (int i = 2; i < nums.length; i += 2) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        //O(n)
        public void wiggleSortN(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (i % 2 == 1 && nums[i] < nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                }
            }
        }
    }

}
