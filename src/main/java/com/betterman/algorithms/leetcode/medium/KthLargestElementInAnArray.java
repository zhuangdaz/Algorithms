package com.betterman.algorithms.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by zhuangda on 1/29/16.
 */
public class KthLargestElementInAnArray {
    public class Solution {
        //time:O(nlogk)
        //space:O(k)
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
            for (int num : nums) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            return heap.poll();
        }

        //quick sort based selection
        //O(N) best case / O(N^2) worst case running time + O(1) memory
        //note: randomizing the array can get O(N) in probabilistic guarantee.
        private final Random random = new Random();
        public int findKthLargestQuickSelect(int[] nums, int k) {
            k = nums.length - k;
            int lo = 0, hi = nums.length - 1;
            while(lo < hi) {
                int i = partition(nums, lo, hi);
                if (i < k) lo = i + 1;
                else if (i > k) hi = i - 1;
                else return nums[k];
            }
            return nums[k];
        }

        private int partition(int[] nums, int lo, int hi) {
            int p = lo + random.nextInt(hi - lo);
            exch(nums, lo, p);
            int v = nums[lo];
            int i = lo, j = hi + 1;
            while(true) {
                while(i < hi && nums[++i] < v);

                while(v < nums[--j]);

                if (i >= j) break;

                exch(nums, i, j);
            }
            exch(nums, lo, j);
            return j;
        }

        private void exch(int[] A, int x, int y) {
            int tmp = A[x];
            A[x] = A[y];
            A[y] = tmp;
        }
    }
}
