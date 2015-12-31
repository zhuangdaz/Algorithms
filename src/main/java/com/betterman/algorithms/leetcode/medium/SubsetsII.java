package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhuangda on 12/31/15.
 */
public class SubsetsII {
    public class Solution {
        //1.for duplicate elements, we can consider to add 0 of them, 1 of them, 2 of them...
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            res.add(new ArrayList());

            for (int i = 0; i < nums.length; i++) {
                int count = 1;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                int n = res.size();
                for (int j = 0; j < n; j++) {
                    List<Integer> newList = new ArrayList(res.get(j));
                    for (int k = 0; k < count; k++) {
                        newList.add(nums[i]);
                        res.add(new ArrayList(newList));
                    }
                }
            }
            return res;
        }

        //2.for duplicate elements, we only add it to last added new sets
        public List<List<Integer>> subsetsWithDup2(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList();
            res.add(new ArrayList());
            int size = 0, start;
            for (int i = 0; i < nums.length; i++) {
                start = i > 0 && nums[i] == nums[i - 1] ? size : 0;
                size = res.size();

                for (int j = start; j < size; j++) {
                    List<Integer> newList = new ArrayList(res.get(j));
                    newList.add(nums[i]);
                    res.add(newList);
                }
            }
            return res;
        }
    }


}
