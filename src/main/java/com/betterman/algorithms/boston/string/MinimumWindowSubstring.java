package com.betterman.algorithms.boston.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }


        int counter = t.length();
        int start = 0, end = 0, min = Integer.MAX_VALUE, minHead = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            if (map[c] > 0) {
                counter--;
            }
            map[c]--;
            end++;

            while (counter == 0) {
                if (end - start < min) {
                    min = end - start;
                    minHead = start;
                }

                c = s.charAt(start);
                if (map[c] == 0) {
                    counter++;
                }
                map[c]++;
                start++;
            }
        }
        if (min > s.length()) {
            return "";
        } else {
            return s.substring(minHead, minHead + min);
        }
    }
}
