package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 2/25/16.
 */
public class CreateMaxNumber {
    public class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            //sub: find max num in one array with k digits
            //sub: find max num in two arrays with m+n digits
            int[] ans = new int[k];
            int m = nums1.length, n = nums2.length;
            for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
                int[] candidate = merge(maxNumber(nums1, i), maxNumber(nums2, k - i), k);
                if (greater(candidate, 0, ans, 0)) ans = candidate;
            }
            return ans;
        }

        //sub: find max num in one array with k digits
        //1.use stack
        //2.pop top if top < nums[i] until stack is empty or numbers left are not enough to fill stack to size k
        private int[] maxNumber(int[] nums, int k) {
            int[] ans = new int[k];
            for (int i = 0, top = 0; i < nums.length; i++) {
                while (top > 0 && top + nums.length - i > k && ans[top - 1] < nums[i]) top--;
                if (top < k) ans[top++] = nums[i];
            }
            return ans;
        }

        //sub: find max num in two arrays with m+n digits
        private int[] merge(int[] nums1, int[] nums2, int k) {
            int[] ans = new int[k];
            for (int i = 0, j = 0, l = 0; l < k; l++) {
                ans[l] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            }
            return ans;
        }

        //Be cautious: when nums1[i]==nums2[j] we need to check the next digit to determine which one to use
        private boolean greater(int[] nums1, int i, int[] nums2, int j) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            return j == nums2.length || (i < nums1.length && nums1[i] >= nums2[j]);
        }


    }
}
