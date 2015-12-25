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
    }
}
