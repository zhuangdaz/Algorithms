package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/25/15.
 */

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */
public class RotateImage {
    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int level = 0; level < n / 2; level++) {
                for (int offset = 0; offset < n - 2 * level - 1; offset++) {
                    int tmp = matrix[level][level + offset]; //up
                    matrix[level][level + offset] = matrix[n - 1 - level - offset][level]; //left;
                    matrix[n - 1 - level - offset][level] = matrix[n - 1 - level][n - 1 - level - offset]; //bottom
                    matrix[n - 1 - level][n - 1 - level - offset] = matrix[level + offset][n - 1 - level]; //right
                    matrix[level + offset][n - 1 - level] = tmp;
                }
            }
        }

        /**
         *
         * clockwise rotate
         * first reverse up to down, then swap the symmetry
         * 1 2 3     7 8 9     7 4 1
         * 4 5 6  => 4 5 6  => 8 5 2
         * 7 8 9     1 2 3     9 6 3
         */

        /**
         * anticlockwise rotate
         * first reverse left to right, then swap the symmetry
         * 1 2 3     3 2 1     3 6 9
         * 4 5 6  => 6 5 4  => 2 5 8
         * 7 8 9     9 8 7     1 4 7
         */
        public void rotate2(int[][] matrix) {
            int n = matrix.length;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n; j++)
                    swap(matrix, i, j, n - 1 - i, j);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
        }

        private void swap (int[][] matrix, int x1, int y1, int x2, int y2) {
            int tmp = matrix[x1][y1];
            matrix[x1][y1] = matrix[x2][y2];
            matrix[x2][y2] = tmp;
        }
    }
}
