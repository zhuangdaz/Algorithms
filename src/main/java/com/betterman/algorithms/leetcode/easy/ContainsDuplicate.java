package com.betterman.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 12/20/15.
 */

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Company Tags Airbnb
 * Tags Array Hash Table
 */
public class ContainsDuplicate {
    public class Solution {
        //time:O(n), space:O(n)
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet();
            for (int num : nums) {
                //@return true if this set did not already contain the specified element
                if (!set.add(num)) return true;
            }
            return false;
        }
    }
}
