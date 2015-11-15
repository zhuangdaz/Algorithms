package com.zhuangda.interview.airbnb;

/**
 * Created by zhuangda on 11/7/15.
 */
public class MaxSubArray {
    /**
     * 一个数组，选出不相邻子序列，要求子序列和最大，
     * [4,9,6]=10
     * [4,10,3,1,5]=15
     */

    //time: O(n), space: O(n)
    public static int findMax(int[] arr) {
        int[] includedMax = new int[arr.length];
        int[] excludedMax = new int[arr.length];

        includedMax[0] = arr[0];
        excludedMax[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            includedMax[i] = excludedMax[i - 1] + arr[i];
            excludedMax[i] = Math.max(includedMax[i - 1], excludedMax[i - 1]);
        }

        return Math.max(includedMax[arr.length - 1], excludedMax[arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]
//                {4,9,6}
//                {4,10,3,1,5}
//                {3, 1, 1, 1, 5}
//                {2, 8, 7, 15, 6}
//                {1, 1, 1, 1}
                {1, 1, 1, 1, 1}
                ;
        System.out.println(findMax(arr));
    }
}
