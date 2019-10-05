package com.betterman.algorithms.boston.trie;

class Trie {
    class TrieNode {
        private final TrieNode[] links;
        private static final int R = 26;
        private boolean isEnd = false;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean contains(char key) {
            return links[key - 'a'] != null;
        }

        public TrieNode get(char key) {
            return links[key - 'a'];
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

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode endNode = searchPrefix(word);
        return endNode != null && endNode.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.contains(c)) {
                return null;
            }
            cur = cur.get(c);
        }
        return cur;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("apples"));
        System.out.println(trie.startsWith("applea"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
