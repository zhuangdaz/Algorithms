package com.betterman.algorithms.boston.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class TrieNode {
        public final TrieNode[] links = new TrieNode[26];
        public String word = null;
    }

    /**
     * Time: O(nml), n * m is the size of board, l is the length of the longest word in words
     * space: O(kl), k is the size of words and l is the length of the longest word in words.
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        int m = board.length, n = board[0].length;
        List<String> res = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.links[c - 'a'] == null) {
                    node.links[c - 'a'] = new TrieNode();
                }
                node = node.links[c - 'a'];
            }
            node.word = word;
        }
    }

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(char[][] board, int x, int y, TrieNode node, List<String> res) {
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || board[x][y] == '#' || node.links[board[x][y] - 'a'] == null) {
            return;
        }
        char c = board[x][y];
        node = node.links[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[x][y] = '#';
        for (int[] dir : dirs) {
            dfs(board, x + dir[0], y + dir[1], node, res);
        }
        board[x][y] = c;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'b', 'b', 'a', 'a', 'b', 'a'},
                {'b', 'b', 'a', 'b', 'a', 'a'},
                {'b', 'b', 'b', 'b', 'b', 'b'},
                {'a', 'a', 'a', 'b', 'a', 'a'},
                {'a', 'b', 'a', 'a', 'b', 'b'}
        };

        String[] words = {"abbbababaa"};
        WordSearchII wordSearchII = new WordSearchII();
        List<String> res = wordSearchII.findWords(board, words);
        System.out.println(res);
    }
}
