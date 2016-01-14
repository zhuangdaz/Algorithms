package com.betterman.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhuangda on 1/13/16.
 */
public class RepeatedDNASequences {
    public static class Solution {
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

        public List<String> findRepeatedDnaSequencesBit(String s) {
            List<String> res = new ArrayList();
            if (s.length() <= 10) return res;
            Set<Integer> once = new HashSet();
            Set<Integer> twice = new HashSet();
            char[] chs = s.toCharArray();
            int[] map = new int[26];
            // map['A' - 'A'] = 0;
            map['C' - 'A'] = 1;
            map['G' - 'A'] = 2;
            map['T' - 'A'] = 3;
            int hash = 0;
            for (int i = 0; i < 9; i++) {
                hash = (hash << 2) | map[chs[i] - 'A'];
            }

            for (int i = 9; i < chs.length; i++) {
                hash = (hash << 2) & 0xfffff | map[chs[i] - 'A'];
                if (!once.add(hash) && twice.add(hash)) res.add(s.substring(i - 9, i + 1));
            }
            return res;
        }
    }
}
