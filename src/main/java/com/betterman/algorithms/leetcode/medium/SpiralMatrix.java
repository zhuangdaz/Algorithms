package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 1/1/16.
 */
public class SpiralMatrix {
    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList();
            if (matrix.length == 0) return res;
            int m = matrix.length, n = matrix[0].length;
            int l = 0, total = (Math.min(m, n) + 1) / 2;

            while (l < total) {
                //right
                for (int col = l; col <= n - 1 - l; col++) res.add(matrix[l][col]);
                //down
                for (int row = l + 1; row <= m - 1 - l; row++) res.add(matrix[row][n - 1 - l]);
                //left
                if (m - 1 - l > l) {
                    for (int col = n - 1 - l - 1; col > l; col--) res.add(matrix[m - 1 - l][col]);
                }

                //up
                if (l < n - 1 - l) {
                    for (int row = m - 1 - l; row > l; row--) res.add(matrix[row][l]);
                }

                l++;
            }
            return res;
        }

        public List<Integer> spiralOrderConcise(int[][] matrix) {
            List<Integer> res = new ArrayList();
            if (matrix.length == 0) return res;
            int m = matrix.length, n = matrix[0].length;

            int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;

            while (rowStart <= rowEnd && colStart <= colEnd) {
                for (int i = colStart; i <= colEnd; i++) res.add(matrix[rowStart][i]);
                rowStart++;

                for (int i = rowStart; i <= rowEnd; i++) res.add(matrix[i][colEnd]);
                colEnd--;

                if (rowStart > rowEnd) break;

                for (int i = colEnd; i >= colStart; i--) res.add(matrix[rowEnd][i]);
                rowEnd--;

                if (colStart > colEnd) break;

                for (int i = rowEnd; i >= rowStart; i--) res.add(matrix[i][colStart]);
                colStart++;
            }

            return res;
        }
    }
}
