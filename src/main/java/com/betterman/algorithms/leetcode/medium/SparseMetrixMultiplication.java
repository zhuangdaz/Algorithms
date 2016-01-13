package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/12/16.
 */
public class SparseMetrixMultiplication {
    public class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, l = A[0].length, n = B[0].length;
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < l; k++) {
                    if (A[i][k] != 0) {
                        for (int j = 0; j < n; j++) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
            return res;
        }
    }
}
