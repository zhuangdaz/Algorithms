package com.betterman.algorithms.leetcode.medium;

import java.util.*;

/**
 * Created by zhuangda on 12/7/15.
 */

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortString = new String(chars);
                map.putIfAbsent(sortString, new ArrayList());
                map.get(sortString).add(str);
            }

            for (String key : map.keySet()) {
                Collections.sort(map.get(key));
            }
            return new ArrayList(map.values());
        }
    }
}
