package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 11/19/15.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = word;

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.word.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        // Initialize your data structure here.
        public TrieNode[] children = new TrieNode[26];
        public String word = "";

        public TrieNode() {

        }
    }

}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");}
