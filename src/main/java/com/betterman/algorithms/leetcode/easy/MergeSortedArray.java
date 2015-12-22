package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 12/21/15.
 */
public class MergeSortedArray {
    public class Solution {
        public void mergeOneline(int[] nums1, int m, int[] nums2, int n) {
            while (n > 0)
                nums1[m + n - 1] = ((m == 0 || nums1[m - 1] <= nums2[n - 1]) ? nums2[--n] : nums1[--m]);
        }

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1, p2 = n - 1;
            for (int i = m + n - 1; i >= 0; i--) {
                if (p1 >= 0 && p2 >= 0) {
                    if (nums1[p1] > nums2[p2]) {
                        nums1[i] = nums1[p1--];
                    } else {
                        nums1[i] = nums2[p2--];
                    }
                } else if (p2 >= 0) {
                    nums1[i] = nums2[p2--];
                } else {
                    return;
                }
            }
        }

        public void mergeClean(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i > - 1 && j > -1) nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            while (j > -1) nums1[k--] = nums2[j--];
        }
    }
}
