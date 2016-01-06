package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 1/6/16.
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
