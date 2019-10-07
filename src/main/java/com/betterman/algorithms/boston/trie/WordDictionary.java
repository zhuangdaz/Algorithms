package com.betterman.algorithms.boston.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
class WordDictionary {
    class TrieNode {
        private TrieNode[] links = new TrieNode[26];
        private boolean isEnd = false;

        public boolean contains(char key) {
            return links[key - 'a'] != null;
        }

        public TrieNode get(char key) {
            return links[key - 'a'];
        }

        public List<TrieNode> getAll() {
            List<TrieNode> res = new ArrayList();
            for (TrieNode l : links) {
                if (l != null) {
                    res.add(l);
                }
            }
            return res;
        }

        public void add(char key) {
            links[key - 'a'] = new TrieNode();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            this.isEnd = true;
        }
    }

    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.contains(c)) {
                cur.add(c);
            }
            cur = cur.get(c);
        }
        cur.setEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, this.root);
    }

    private boolean search(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return root.isEnd();
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            String substring = word.substring(i + 1);
            if (c == '.') {
                List<TrieNode> links = root.getAll();
                return links.stream().anyMatch(l -> search(substring, l));
            } else if (!root.contains(c)) {
                return false;
            } else {
                return search(substring, root.get(c));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */