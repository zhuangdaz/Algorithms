package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 1/7/16.
 */
public class ValidWordAbbr {
    Map<String, String> dict = new HashMap();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (dict.containsKey(abbr)) {
                if (!dict.get(abbr).equals(word))
                    dict.put(abbr, "");
            } else {
                dict.put(abbr, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!dict.containsKey(abbr) || dict.get(abbr).equals(word)) return true;
        else return false;
    }

    private String getAbbr(String word) {
        return word.length() <= 2 ? word : word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");