package com.betterman.algorithms.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuangda on 1/27/16.
 */
public class PermutationSequence {
    public class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> nums = new LinkedList();
            StringBuffer sb = new StringBuffer();

            int cnt = 1;
            for (int i = 1; i <= n; i++) {
                cnt *= i;
                nums.add(i);
            }

            for (int i = n; i > 0; i--) {
                cnt /= i;
                int index = (k - 1) / cnt;
                sb.append(nums.remove(index));
                k -= index * cnt;
            }

            return sb.toString();
        }
    }
}
