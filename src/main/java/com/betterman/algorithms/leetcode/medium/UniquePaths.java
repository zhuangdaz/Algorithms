package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/22/15.
 */
public class UniquePaths {
    public class Solution {
        //time: O(mn); space:O(mn) - DP
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m + 1][n + 1];
            grid[m][n - 1] = 1;

            for (int row = m - 1; row > -1; row--) {
                for (int col = n - 1; col > -1; col--) {
                    grid[row][col] = grid[row + 1][col] + grid[row][col + 1];
                }
            }

            return grid[0][0];
        }

        //time: O(mn); space:O(n) - DP
        public int uniquePaths2(int m, int n) {
            int[] lastRow = new int [n + 1];
            lastRow[n - 1] = 1;

            for (int row = m - 1; row > -1; row--) {
                for (int col = n - 1; col > -1; col--) {
                    lastRow[col] += lastRow[col + 1];
                }
            }
            return lastRow[0];
        }

        //time: O(n); space:O(1)
        //total: m+n-2 movements
        //left: n-1 movements
        //down: m-1 movements
        //unique paths: combinations Math.min(left, down) movements from total.
        public int uniquePathsFormula(int m, int n) {
            double res = 1;

            int k = Math.min(m - 1, n - 1);
            int N = m + n - 2;

            for (int i = 1; i <= k; i++, N--) {
                res = res * N / i;
            }

            return (int)res;
        }
    }
}
