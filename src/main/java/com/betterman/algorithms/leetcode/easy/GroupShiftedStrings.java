package com.betterman.algorithms.leetcode.easy;

import java.util.*;

/**
 * Created by zhuangda on 12/5/15.
 */
public class GroupShiftedStrings {
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Arrays.sort(strings);
            Map<String, List<String>> map = new HashMap();

            for (String word : strings) {
                String key = getKey(word);
                map.putIfAbsent(key, new ArrayList());
                map.get(key).add(word);
            }

            List<List<String>> res = new ArrayList();
            return new ArrayList(map.values());
        }

        private String getKey(String word) {
            char[] chs = word.toCharArray();
            int offset = chs[0] - 'a';
            for (int i = 0; i < chs.length; i++) {
                chs[i] -= offset;
                if (chs[i] < 'a') chs[i] += 26;
            }
            BitSet bitSet = new BitSet();
            return new String(chs);
        }
    }


}
