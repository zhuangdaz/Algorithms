package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/24/15.
 */
public class Search2DMatrix {
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int lo = 0, hi = matrix.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (matrix[mid][0] == target) return true;
                else if (matrix[mid][0] < target) lo = mid + 1;
                else hi = mid - 1;
            }

            if (hi == -1) return false;

            int row = hi;
            lo = 0;
            hi = matrix[0].length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (matrix[row][mid] == target) return true;
                else if (matrix[row][mid] < target) lo = mid + 1;
                else hi = mid - 1;
            }
            return false;
        }
    }
}
