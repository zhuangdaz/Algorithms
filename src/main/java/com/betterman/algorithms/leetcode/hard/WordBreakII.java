package com.betterman.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhuangda on 2/27/16.
 */
public class WordBreakII {
    public class Solution {
        public List<String> wordBreak(String s, Set<String> wordDict) {
            Map<String, List<String>> mem = new HashMap();
            return wordBreak(s, wordDict, mem);
        }

        private List<String> wordBreak(String s, Set<String> wordDict, Map<String, List<String>> mem) {
            if (mem.containsKey(s)) return mem.get(s);

            List<String> ans = new ArrayList();

            if (wordDict.contains(s)) {
                ans.add(s);
            }

            for (int i = 0; i < s.length(); i++) {
                String word = s.substring(0, i + 1);
                if (wordDict.contains(word)) {
                    List<String> sens = wordBreak(s.substring(i + 1, s.length()), wordDict, mem);

                    for (String sen : sens) {
                        ans.add(word + " " + sen);
                    }
                }
            }

            mem.put(s, ans);

            return ans;
        }
    }
}
