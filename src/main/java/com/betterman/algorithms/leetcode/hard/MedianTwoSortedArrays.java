package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 10/13/15.
 */
public class MedianTwoSortedArrays {
    public class Solution {
        public double findMedianSortedArrays(int[] A, int[] B) {
            // key is to find A[l], A[l - 1], B[k - l], B[k - l + 1]; A[l] >= B[k - l]
            // It is hard to find exact kth element in A, a lot of conditions to check;
            // but surprisingly enough,
            // we can easily find the first element in A after k elements in combined array
            // then we can get the kth element with a single comparison.:)
            int m = A.length;
            int n = B.length;

            if (m > n) return findMedianSortedArrays(B, A);

            int k = (m + n - 1) / 2;
            int l = 0;
            int r = Math.min(k + 1, m);

            while (l < r) {
                int midA = l + (r - l) / 2;
                int midB = k - midA;
                if (A[midA] < B[midB]) {
                    l = midA + 1;
                } else {
                    r = midA;
                }
            }

            int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);

            if ((m + n) % 2 == 1) {
                return (double) a;
            }

            int b = Math.min(l < m ? A[l] : Integer.MAX_VALUE, k - l + 1 < n ? B[k - l + 1] : Integer.MAX_VALUE);

            return (a + b) / 2.0;

        }
    }
}
