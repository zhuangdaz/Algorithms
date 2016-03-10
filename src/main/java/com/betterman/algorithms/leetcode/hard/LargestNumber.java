package com.betterman.algorithms.leetcode.hard;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/8/16.
 */
public class LargestNumber {
    public class Solution {
        //O(len*nlogn)
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = Integer.toString(nums[i]);
            }

            Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

            //case:[0, 0]
            if (strs[0].equals("0")) return "0";

            StringBuilder sb = new StringBuilder();
            for (String s : strs) sb.append(s);
            return sb.toString();
        }
    }

}
