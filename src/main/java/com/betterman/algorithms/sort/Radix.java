package com.betterman.algorithms.sort;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/7/16.
 */
public class Radix {
    public static final void sort(int[] nums, int n) {
        int max = max(nums);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, n, exp);
        }
    }

    private static void countSort(int[] nums, int n, int exp) {
        int[] tmp = new int[n];
        int[] buckets = new int[10];

        for (int num : nums) {
            buckets[(num / exp) % 10]++;
        }

        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i-1];
        }

        for (int i = n - 1; i >= 0; i--) {
            tmp[(buckets[(nums[i] / exp) % 10]--) - 1] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = tmp[i];
        }
    }

    private static int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
