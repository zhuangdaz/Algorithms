package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 11/16/15.
 */
public class ThreeSum {

    public class Solution {
        // sort array
        // one pointer to traverse the array
        // two more pointers: one points to i+1, another one points to the end
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList();

            Arrays.sort(nums); //O(nlogn)

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (nums[i] > 0) break; //already greater than 0

                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }

                    if (nums[i] + nums[j] > 0) break;

                    int sum = nums[j] + nums[k];

                    if (sum + nums[i] == 0) {
                        List<Integer> triplet = new ArrayList();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        ret.add(triplet);

                        j++;
                        k--;
                    } else if (sum + nums[i] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }

            }
            return ret;
        }
    }
}
