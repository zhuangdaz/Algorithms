package com.betterman.algorithms.leetcode.hard;

import java.util.*;

/**
 * Created by zhuangda on 11/17/15.
 */

//TODO: two end BFS solution:
//https://leetcode.com/discuss/41689/88ms-accepted-solution-with-68ms-word-ladder-88ms-word-ladder
public class WordLadderII {
    public static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            List<List<String>> ret = new ArrayList();
            List<List<String>> tmp = new ArrayList();
            List<String> initList = new ArrayList();
            initList.add(beginWord);
            tmp.add(initList);
            wordList.add(beginWord);
            wordList.add(endWord);
            Map<String, Set<String>> expandWords = new HashMap();
            Set<String> globalUsedWords = new HashSet();
            while (true) {
                List<List<String>> newBranches = new ArrayList();
                Set<String> usedWords = new HashSet();

                Iterator<List<String>> iter = tmp.iterator();
                while (iter.hasNext()) {
                    List<String> branch = iter.next();

                    String lastWord = branch.get(branch.size() - 1);

                    if (!expandWords.containsKey(lastWord)) {
                        expandWords.put(lastWord, expand(lastWord, wordList));
                    }

                    if (expandWords.get(lastWord).contains(endWord)) {
                        branch.add(endWord);
                        ret.add(branch);
                        iter.remove();
                        continue;
                    }

                    for (String next : expandWords.get(lastWord)) {
                        if (globalUsedWords.contains(next)) continue;
                        List<String> newBranch = new ArrayList(branch);
                        newBranch.add(next);
                        newBranches.add(newBranch);
                        usedWords.add(next);
                    }
                    iter.remove();
                }

                if (ret.size() > 0 || newBranches.size() == 0) return ret;
                tmp = newBranches;
                globalUsedWords.addAll(usedWords);
                wordList.removeAll(usedWords);
            }

        }

        /**
         * Generate a list of words expanded from the word
         * Skip if it's the same character
         * If word is in dictionary, add to expansion list
         */
        private Set<String> expand(String word, Set<String> dict) {
            Set<String> res = new HashSet<String>();
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chs = word.toCharArray();
                    if (ch != chs[i]) {
                        chs[i] = ch;
                        String next = new String(chs);
                        if (dict.contains(next)) res.add(next);
                    }
                }
            }
            return res;
        }
    }

    public static class Solution2 {
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            List<List<String>> res = new ArrayList<List<String>>();
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            Map<String, Integer> dist = new HashMap<String, Integer>();

            bfs(map, dist, start, end, dict);
            dfs(res, new LinkedList<String>(), end, start, dist, map);
            return res;
        }

        /**
         * Create a queue, add start to it and put start in dist map
         * Initialize map with lists
         */
        void bfs(Map<String, List<String>> map, Map<String, Integer> dist,
                 String start, String end, Set<String> dict) {
            Queue<String> q = new LinkedList<String>();
            q.offer(start);
            dict.add(start); // make sure start and end in dictionary
            dict.add(end);
            dist.put(start, 0);
            for (String s : dict) map.put(s, new ArrayList<String>());

            while (!q.isEmpty()) {
                String word = q.poll();
                List<String> expansion = expand(word, dict); // generate all words
                for (String next : expansion) {
                    map.get(next).add(word);
                    if (!dist.containsKey(next)) { // not in dist map yet
                        dist.put(next, dist.get(word) + 1);
                        q.offer(next);
                    }
                }
            }
        }

        /**
         * Generate a list of words the word
         * Skip if it's the same character
         * If word is in dictionary, add to expansion list
         */
        List<String> expand(String word, Set<String> dict) {
            List<String> res = new ArrayList<String>();
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chs = word.toCharArray();
                    if (ch != chs[i]) {
                        chs[i] = ch;
                        String next = new String(chs);
                        if (dict.contains(next)) res.add(next);
                    }
                }
            }
            return res;
        }

        /**
         * Add current word to first position
         * Add path to result if word is start
         */
        void dfs(List<List<String>> res, List<String> path, String word, String start, Map<String, Integer> dist, Map<String, List<String>> map) {
            if (word.equals(start)) {
                path.add(0, word);
                res.add(new ArrayList<String>(path));
                path.remove(0);
                return; // note to return
            }
            for (String next : map.get(word)) {
                if (dist.containsKey(next) && dist.get(word) == dist.get(next) + 1) { // backward, so word = next + 1
                    path.add(0, word); // add current word
                    dfs(res, path, next, start, dist, map); // dfs next word
                    path.remove(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "abc";
        String[] arr = {"hit", "hat", "bot"};
        Set<String> dict = new HashSet<String>(Arrays.asList(arr));
//        System.out.println(new Solution().findLadders(start, end, dict).toString());
        System.out.println(new Solution2().findLadders(start, end, dict).toString());
    }
}
