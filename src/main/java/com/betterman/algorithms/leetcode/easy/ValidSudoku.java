package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/9/16.
 */
public class ValidSudoku {
    public static class Solution {
        private static int N = 9;

        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < N; i++) {
                if (!isParticallyValid(board, i, 0, i, N - 1)) return false;
            }

            for (int j = 0; j < N; j++) {
                if (!isParticallyValid(board, 0, j, N - 1, j)) return false;
            }

            int K = N / 3;
            for (int k = 0; k < K; k++) {
                for (int l = 0; l < K; l++) {
                    int x = 3 * k, y = 3 * l;
                    if (!isParticallyValid(board, x, y, x + 2, y + 2)) return false;
                }
            }
            return true;
        }

        private boolean isParticallyValid(char[][] board, int x1, int y1, int x2, int y2) {
            boolean[] filled = new boolean[N];
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (board[i][j] == '.') continue;
                    int idx = board[i][j] - '1';
                    if (filled[idx]) return false;
                    else filled[idx] = true;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.print(Math.sqrt(4));
    }
}
