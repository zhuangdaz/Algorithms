package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhuangda on 1/13/16.
 */
public class RepeatedDNASequences {
    public class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList();
            Set<String> words = new HashSet();
            Set<String> doubleWords = new HashSet();
            for (int i = 9; i < s.length(); i++) {
                String word = s.substring(i - 9, i + 1);
                if (!words.add(word) && doubleWords.add(word)) res.add(word);
            }
            return res;
        }
    }
}
