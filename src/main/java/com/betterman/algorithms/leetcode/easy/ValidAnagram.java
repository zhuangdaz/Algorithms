package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/9/16.
 */

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {
    public class Solution {
        //confirm: size of the possible characters, whether same strings considered as anagram
        public boolean isAnagram(String s, String t) {
            int[] ascii = new int[26];
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();

            if (schars.length != tchars.length) return false;
            for (int i = 0; i < schars.length; i++) {
                ascii[schars[i] - 'a']++;
                ascii[tchars[i] - 'a']--;
            }

            for (int count : ascii) {
                if (count != 0) return false;
            }
            return true;
        }
    }
}
