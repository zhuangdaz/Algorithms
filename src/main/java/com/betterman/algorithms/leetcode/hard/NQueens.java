package com.betterman.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 2/29/16.
 */
public class NQueens {
    public class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            boolean[] isOccupied = new boolean[5 * n - 1];
            List<List<String>> ans = new ArrayList();
            dfs(board, 0, isOccupied, ans, n);
            return ans;
        }

        private void dfs(char[][] board, int row, boolean[] isOccupied, List<List<String>> ans, int n) {
            if (row == n) {
                List<String> one = new ArrayList();
                for (char[] r : board) {
                    one.add(new String(r));
                }
                ans.add(one);
            } else {
                for (int col = 0; col < n; col++) {
                    if (!isOccupied[col] &&
                            !isOccupied[2 * n - 1 + row - col] &&
                            !isOccupied[3 * n - 1 + row + col]) {
                        board[row][col] = 'Q';
                        isOccupied[col] = true;
                        isOccupied[2 * n - 1 + row - col] = true;
                        isOccupied[3 * n - 1 + row + col] = true;
                        dfs(board, row + 1, isOccupied, ans, n);
                        board[row][col] = '.';
                        isOccupied[col] = false;
                        isOccupied[2 * n - 1 + row - col] = false;
                        isOccupied[3 * n - 1 + row + col] = false;
                    }
                }
            }
        }
    }
}
