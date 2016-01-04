package com.betterman.algorithms.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 1/3/16.
 */
public class LongestConsecutiveSequence {
    public class Solution {
        public int longestConsecutive(int[] nums) {
            int max = 1;
            Set<Integer> set = new HashSet();
            for (int num : nums) set.add(num);

            for (int num : nums) {
                if (set.remove(num)) {
                    int count = 1;
                    int val = num;
                    while (set.remove(val - 1)) {
                        count++;
                        val--;
                    }

                    val = num;
                    while (set.remove(val + 1)) {
                        count++;
                        val++;
                    }
                    if (count > max) max = count;
                    if (set.isEmpty()) break;
                }
            }
            return max;
        }
    }

}
