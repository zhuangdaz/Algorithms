package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 1/5/16.
 */
public class StrobogrammaticNumber {
    public class Solution {
        //corner case: "2"
        //questions:
        //1.is num an integer?
        //2.is num a non-negative integer?
        public boolean isStrobogrammatic(String num) {
            Map<Character, Character> map = new HashMap();
            map.put('1', '1');
            map.put('6', '9');
            map.put('8', '8');
            map.put('9', '6');
            map.put('0', '0');
            char[] chars = num.toCharArray();
            int lo = 0, hi = chars.length - 1;
            while (lo <= hi) {
                if (!map.containsKey(chars[lo]) || chars[hi] != map.get(chars[lo])) {
                    return false;
                } else {
                    lo++;
                    hi--;
                }
            }
            return true;
        }
    }
}
