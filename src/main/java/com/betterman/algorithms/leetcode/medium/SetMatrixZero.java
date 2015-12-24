package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/24/15.
 */
public class SetMatrixZero {
    public class Solution {
        //Space - O(m + n)
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            boolean[] rowZero = new boolean[rows];
            boolean[] colZero = new boolean[cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        rowZero[i] = true;
                        colZero[j] = true;
                    }
                }
            }

            for (int i = 0; i < rowZero.length; i++) {
                for (int j = 0; j < colZero.length; j++) {
                    if (rowZero[i] || colZero[j]) matrix[i][j] = 0;
                }
            }
        }

        //Space - O(1)
        public void setZeroesConstantSpace(int[][] matrix) {
            int col0 = 1, rows = matrix.length, cols = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) col0 = 0;
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }


            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 1; j--) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

                if (col0 == 0) matrix[i][0] = 0;
            }


        }
    }
}
