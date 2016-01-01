package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/1/16.
 */
public class SpiralMatrixII {
    public class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int val = 1;
            int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = colStart; i <= colEnd; i++) res[rowStart][i] = val++;
                rowStart++;

                for (int i = rowStart; i <= rowEnd; i++) res[i][colEnd] = val++;
                colEnd--;

                if (rowStart > rowEnd) break;
                for (int i = colEnd; i >= colStart; i--) res[rowEnd][i] = val++;
                rowEnd--;

                if (colStart > colEnd) break;
                for (int i = rowEnd; i >= rowStart; i--) res[i][colStart] = val++;
                colStart++;
            }
            return res;
        }
    }
}
