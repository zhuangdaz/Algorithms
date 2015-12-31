package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 12/30/15.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word.toCharArray(), 0)) return true;
            }
        }
        return false;

    }

    private boolean helper(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        if (x < 0 || x == board.length || y < 0 || y == board[0].length || board[x][y] != word[i]) return false;

        board[x][y] = '*'; //Assumption: there is no '*' in the word.
        boolean res = helper(board, x - 1, y, word, i+1) ||
            helper(board, x + 1, y, word, i+1) ||
            helper(board, x, y - 1, word, i+1) ||
            helper(board, x, y + 1, word, i+1);
        board[x][y] = word[i];
        return res;
    }
}
