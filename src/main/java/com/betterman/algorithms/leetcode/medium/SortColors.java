package com.betterman.algorithms.leetcode.medium;

import java.util.Arrays;

/**
 * Created by zhuangda on 1/1/16.
 */
public class SortColors {
    public class Solution {
        public void sortColors(int[] nums) {
            int p0 = 0, p1 = 0, p2 = nums.length - 1;

            while (p1 <= p2) {
                if (nums[p1] == 0) {
                    swap(nums, p0++, p1++);
                } else if (nums[p1] == 2) {
                    swap(nums, p1, p2--);
                } else {
                    p1++;
                }
            }
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        swap(nums, 0, 2);
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] + nums[y];
        nums[y] = nums[x] - nums[y];
        nums[x] = nums[x] - nums[y];
    }
}
