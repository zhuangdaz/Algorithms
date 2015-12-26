package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 11/16/15.
 */
public class ThreeSum {

    public static class Solution {
        // sort array
        // one pointer to traverse the array
        // two more pointers: one points to i+1, another one points to the end
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList();

            int i = 0;
            while (i < nums.length - 2) {
                int l = i + 1;
                int r = nums.length - 1;
                int sum = nums[i] * -1;

                while (l < r) {
                    int s = nums[l] + nums[r];
                    if (s < sum) l++;
                    else if (s > sum) r--;
                    else {
                        List<Integer> match = new ArrayList();
                        match.add(nums[i]);
                        match.add(nums[l]);
                        match.add(nums[r]);
                        res.add(match);
                        l++;
                        r--;

                        while (l < nums.length - 1 && nums[l] == nums[l - 1]) l++;
                        while (r > 0 && nums[r] == nums[r + 1]) r--;
                    }
                }

                i++;
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
            }
            return res;
        }

        public List<List<Integer>> threeSumConcise(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList();

            //if i must be incremented for each iteration then use FOR loop.
            //otherwise, use WHILE loop.
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (nums[i] > 0) break;

                int target = -nums[i];
                int lo = i + 1;
                int hi = nums.length - 1;

                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum == target) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[lo], nums[hi]);
                        res.add(triplet);
                        while (lo < hi && nums[lo] == triplet.get(1)) lo++;
                        while (lo < hi && nums[hi] == triplet.get(2)) hi--;
                    }
                    else if (sum < target) lo++;
                    else hi--;
                }
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1};
        System.out.println(solution.threeSum(nums));
    }
}
