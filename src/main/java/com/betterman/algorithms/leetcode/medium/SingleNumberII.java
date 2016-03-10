package com.betterman.algorithms.leetcode.medium;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by zhuangda on 3/9/16.
 */
public class SingleNumberII {
    public class Solution {
        public int singleNumber(int[] nums) {
            int[] bit = new int[32];
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                for (int num : nums) {
                    bit[i] += (num >> i) & 1;
                }
                ans |= (bit[i] % 3) << i;
            }
            return ans;
        }

        public int singleNumberSmart(int[] nums) {
            int ones = 0, twos = 0;
            for (int num : nums) {
                ones = (ones ^ num) & (~twos);
                twos = (twos ^ num) & (~ones);
            }
            return ones;
        }
    }

    public static void main(String[] args) {
        int num = 2;
        System.out.println(num ^ (-num));
    }
}
