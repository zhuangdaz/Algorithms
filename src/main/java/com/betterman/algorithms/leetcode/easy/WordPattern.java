package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 1/6/16.
 */

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a
 * non-empty word in str.
 *
 * Examples: pattern = "abba", str = "dog cat cat dog" should return true. pattern = "abba", str =
 * "dog cat cat fish" should return false. pattern = "aaaa", str = "dog cat cat dog" should return
 * false. pattern = "abba", str = "dog dog dog dog" should return false. Notes: You may assume
 * pattern contains only lowercase letters, and str contains lowercase letters separated by a single
 * space.
 */
public class WordPattern {
    public class Solution {
        // tests: aba, cat dog cat - true; aba, cat cat cat - false; aba, a b a - true
        public boolean wordPattern(String pattern, String str) {
            Map map = new HashMap();
            String[] words = str.split(" ");
            char[] chars = pattern.toCharArray();
            if (chars.length != words.length) return false;
            //Notice: use Integer instead of int here.
            for (Integer i = 0; i < chars.length; i++) {
                /**
                 *  @return the previous value associated with <tt>key</tt>, or
                 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
                 *         (A <tt>null</tt> return can also indicate that the map
                 *         previously associated <tt>null</tt> with <tt>key</tt>,
                 *         if the implementation supports <tt>null</tt> values.)
                 */
                if (map.put(chars[i], i) != map.put(words[i], i))
                    //use different types of keys here (character, string)
                    //so it passes this case:aba, a b a
                    return false;
            }
            return true;
        }
    }
}
