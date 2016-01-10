package com.betterman.algorithms.leetcode.easy;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 1/9/16.
 */
public class PalindromePermutation {
    public class Solution {
        public boolean canPermutePalindrome(String s) {
            s.getBytes();
            char[] chs = s.toCharArray();
            Set<Character> set = new HashSet();
            for (char c : chs) if (!set.add(c)) set.remove(c);
            return set.size() <= 1;
        }

        public boolean canPermutePalindromeBitSet(String s) {
            char[] chs = s.toCharArray();
            BitSet bs = new BitSet();
            for (char c : chs) {
                bs.flip(c);
            }
            return bs.cardinality() <= 1;
        }
    }
}
