package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        //Use set instead of map
        // Remove number from set once it's out of range which is k
        public boolean containsNearbyDuplicateWithSet(int[] nums, int k) {
            Set<Integer> set = new HashSet();
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }
                /**
                 *  @return <tt>true</tt> if this set did not already contain the specified
                 *         element
                 */
                if (!set.add(nums[i])) return true;
            }
            return false;
        }
    }
}
