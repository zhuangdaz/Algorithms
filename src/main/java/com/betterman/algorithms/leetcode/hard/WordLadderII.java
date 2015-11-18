package com.betterman.algorithms.leetcode.hard;

import java.util.*;

/**
 * Created by zhuangda on 11/17/15.
 */
public class WordLadderII {
    public static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            List<List<String>> ret = new ArrayList();
            List<List<String>> tmp = new ArrayList();
            List<String> initList = new ArrayList();
            initList.add(beginWord);
            tmp.add(initList);

            HashSet<String> visited = new HashSet();
            while (true) {
                List<List<String>> newBranches = new ArrayList();
                Set<String> usedWords = new HashSet();
                HashSet<String> visiting = new HashSet();

                Iterator<List<String>> iter = tmp.iterator();
                while (iter.hasNext()) {
                    List<String> branch = iter.next();
                    boolean invalid = false;
                    for (int i = 1; i < branch.size(); i++) {
                        if (visited.contains(branch.get(i))) {
                            //exist a shorter path
                            invalid = true;
                            break;
                        }
                    }

                    if (invalid) {
                        iter.remove();
                        continue;
                    }

                    String lastWord = branch.get(branch.size() - 1);
                    if (transformable(lastWord, endWord)) {
                        visiting.addAll(branch.subList(1, branch.size()));
                        branch.add(endWord);
                        ret.add(branch);
                        iter.remove();
                        continue;
                    }

                    List<String> expandWords = expand(lastWord, wordList);
                    for (String next : expandWords) {
                        List<String> newBranch = new ArrayList(branch);
                        newBranch.add(next);
                        newBranches.add(newBranch);
                        usedWords.add(next);
                    }
                    iter.remove();
                }

                visited.addAll(visiting);
                if (newBranches.size() == 0) return ret;
                tmp = newBranches;
                wordList.removeAll(usedWords);
            }

        }

        /**
         * Generate a list of words the word
         * Skip if it's the same character
         * If word is in dictionary, add to expansion list
         */
        private List<String> expand(String word, Set<String> dict) {
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

        private boolean transformable(String word1, String word2) {
            int diff = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) == word2.charAt(i)) continue;
                else if (diff == 1) return false;
                else diff++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] arr = {"hot", "dot", "dog", "lot", "log"};
        Set<String> dict = new HashSet<String>(Arrays.asList(arr));
        System.out.println(new Solution().findLadders(start, end, dict).toString());
    }
}
