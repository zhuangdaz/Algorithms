package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 2/27/16.
 */

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word) bool search(word) search(word) can search a literal word or a regular
 * expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note: You may assume that all words are consist of lowercase letters a-z.
 */
public class AddSearchWord {
    public static class WordDictionary {
        TrieNode root = new TrieNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode node = root;
            char[] chs = word.toCharArray();
            for (char c : chs) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(word.toCharArray(), 0, root);
        }

        private boolean search(char[] chs, int i, TrieNode node) {
            if (i == chs.length) {
                return !node.word.equals("");
            }

            char c = chs[i];
            if (c == '.') {
                for (int j = 0; j < node.children.length; j++) {
                    TrieNode child = node.children[j];
                    if (child != null && search(chs, i + 1, child)) return true;
                }
                return false;
            } else {
                return node.children[c - 'a'] != null &&
                        search(chs, i + 1, node.children[c - 'a']);
            }
        }

        class TrieNode {
            String word = "";
            TrieNode[] children = new TrieNode[26];

            public TrieNode() {
            }
        }
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("ran");
        dictionary.addWord("rune");
        dictionary.addWord("runner");
        dictionary.addWord("runs");
        dictionary.addWord("add");
        dictionary.addWord("adds");
        dictionary.addWord("adder");
        dictionary.addWord("addee");
        System.out.println(dictionary.search("....e."));
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}
