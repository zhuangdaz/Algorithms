package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 12/21/15.
 */
public class ContainsDuplicateII {
    public class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                if (map.containsKey(num) && i - map.get(num) <= k) return true;
                else map.put(num, i);
            }
            return false;
        }
    }
}
