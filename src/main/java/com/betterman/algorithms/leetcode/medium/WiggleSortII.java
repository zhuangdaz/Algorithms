package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/7/16.
 */
public class WiggleSortII {
    public static class Solution {
        public void wiggleSort(int[] nums) {
            int mid = findKth(nums, (nums.length - 1) / 2, 0, nums.length - 1);
            int len = nums.length;
            int lt = 0, i = 0, gt = nums.length - 1;
            while (i <= gt) {
                int ci = convert(i, len);
                int clt = convert(lt, len);
                int cgt = convert(gt, len);
                int cmp = Integer.compare(nums[ci], mid);
                if (cmp > 0) {
                    swap(nums, ci, clt);
                    i++;
                    lt++;
                } else if (cmp < 0) {
                    swap(nums, ci, cgt);
                    gt--;
                } else {
                    i++;
                }
            }
        }

        private int convert(int i, int n) {
//            return (i * 2) % ((n > 1) ? (n - 1) : 1);
            return (1+2*(i)) % (n|1);
        }

        private int findKth(int[] nums, int k, int lo, int hi) {
            if (lo >= hi) return nums[lo];
            int v = nums[lo];
            int i = lo, j = hi + 1;

            while (true) {
                while (nums[++i] < v) if (i == hi) break;
                while (nums[--j] > v) ;

                if (i >= j) break;

                swap(nums, i, j);
            }
            swap(nums, lo, j);

            if (j == k) return nums[j];
            else if (j < k) return findKth(nums, k, j + 1, hi);
            else return findKth(nums, k, lo, j - 1);
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 5, 1, 1, 6, 4};
        solution.wiggleSort(arr);
        System.out.println(arr);
    }
}
