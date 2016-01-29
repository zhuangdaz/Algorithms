package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/28/16.
 */
public class Search2DMatrixII {
    public class Solution {
        //O(m+n)
        public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] < target) {
                    i++;
                } else if (matrix[i][j] > target) {
                    j--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
