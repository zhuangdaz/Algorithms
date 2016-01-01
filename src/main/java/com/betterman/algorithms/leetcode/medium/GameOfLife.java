package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/31/15.
 */
public class GameOfLife {
    public class Solution {
        // More elegant solution:
        // 00 -- dead(current) -> dead(next)
        // 01 -- live(current) -> dead(next)
        // 10 -- dead(current) -> live(next)
        // 11 -- live(current) -> live(next)

        // use board[i][j] & 1 to get current status
        // use board[i][j] >> 1 to get next status

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    int count = lives(board, i, j);
                    if (board[i][j] % 2 == 1) {
                        if (count < 2) board[i][j] = 3;
                        else if (count <= 3) board[i][j] = 1;
                        else board[i][j] = 3;
                    }
                    else if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 2) board[i][j] = 1;
                    else if (board[i][j] == 3) board[i][j] = 0;
                }
            }
        }

        private int lives(int[][] board, int x, int y) {
            int count = 0;
            int rowStart = Math.max(x - 1, 0), rowEnd = Math.min(x + 1, board.length - 1);
            int colStart = Math.max(y - 1, 0), colEnd = Math.min(y + 1, board[0].length - 1);

            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = colStart; j <= colEnd; j++) {
                    if (i != x || j != y) {
                        if (board[i][j] % 2 == 1) count++;
                    }
                }
            }
            return count;
        }
    }
}
