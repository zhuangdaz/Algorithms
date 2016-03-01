package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 3/1/16.
 */
public class NQueensII {
    public class Solution {
        int count;

        public int totalNQueens(int n) {
            count = 0;
            boolean[] isOccupied = new boolean[5 * n - 2];
            dfs(isOccupied, 0, n);
            return count;
        }

        private void dfs(boolean[] isOccupied, int row, int n) {
            if (row == n) count++;
            else {
                for (int col = 0; col < n; col++) {
                    if (!isOccupied[col] &&
                            !isOccupied[2 * n - 1 + row - col] &&
                            !isOccupied[3 * n - 1 + row + col]) {
                        isOccupied[col] = true;
                        isOccupied[2 * n - 1 + row - col] = true;
                        isOccupied[3 * n - 1 + row + col] = true;
                        dfs(isOccupied, row + 1, n);
                        isOccupied[col] = false;
                        isOccupied[2 * n - 1 + row - col] = false;
                        isOccupied[3 * n - 1 + row + col] = false;
                    }
                }
            }
        }
    }
}
