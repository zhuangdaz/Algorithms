package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 1/14/16.
 */
public class SudokuSolver {
    public class Solution {
        public void solveSudoku(char[][] board) {
            helper(board, 0, 0);
        }

        private boolean helper(char[][] board, int x, int y) {
            if (y == 9) {
                x++;
                y = 0;
            }

            if (x == 9) return true;

            if (board[x][y] != '.') return helper(board, x, y + 1);

            boolean[] m = new boolean[9];
            check(m, board, x, 0, x, 8);
            check(m, board, 0, y, 8, y);
            check(m, board, x / 3 * 3, y / 3 * 3, x / 3 * 3 + 2, y / 3 * 3 + 2);

            for (int i = 0; i < m.length; i++) {
                if (!m[i]) {
                    board[x][y] = (char) ('1' + i);
                    if (helper(board, x, y + 1)) return true;
                }
            }
            board[x][y] = '.';
            return false;
        }

        private void check(boolean[] m, char[][] board, int x0, int y0, int x1, int y1) {
            for (int i = x0; i <= x1; i++) {
                for (int j = y0; j <= y1; j++) {
                    if (board[i][j] != '.')
                        m[board[i][j] - '1'] = true;
                }
            }
        }
    }
}
