package com.zhuangda.interview.airbnb;

import com.zhuangda.leetcode.hard.ShortestPalindrome;

import java.util.*;

/**
 * Created by zhuangda on 11/8/15.
 */
public class PalindromePair {
    //ca, acb
    //abc, cba
    //abcc, ba
    //abab, aba

    //  Iterate the list find all palindromes(find shortest first) for this word, adding to the front and to the end,
    //  put them in map<String, Set<String>>.
    private static ShortestPalindrome.Solution shortestPalindromeFinder = new ShortestPalindrome.Solution();

    /**
     * Given a list of word, output all pair of words that can be formed as a palindrome
     */
    private static void find(List<String> words) {
        Map<String, Set<String>> expectings = new HashMap<String, Set<String>>();
        Set<String> processed = new HashSet<String>();
        for (String word : words) {
            Set<String> matches = new HashSet<String>();

            if (expectings.containsKey(word)) {
                matches.addAll(expectings.get(word));
            }

            Set<String> palindromes = new HashSet<String>();
            String shortestAppendToFront = shortestPalindromeFinder.getShortestStringToMakePalindrome(word);
            for (int i = 0; word.length() - i >= shortestAppendToFront.length(); i++) {
                palindromes.add(new StringBuffer(word.substring(i, word.length())).reverse().toString());
            }

            String shortestAppendToEnd = new StringBuffer(
                shortestPalindromeFinder.getShortestStringToMakePalindrome(new StringBuffer(word).reverse().toString()))
                .reverse().toString();
            for (int i = word.length() - 1; i + 1 >= shortestAppendToEnd.length(); i--) {
                palindromes.add(new StringBuffer(word.substring(0, i + 1)).reverse().toString());
            }

            for (String palindrome : palindromes) {
                if (processed.contains(palindrome)) {
                    matches.add(palindrome);
                } else {
                    if (!expectings.containsKey(palindrome)) {
                        expectings.put(palindrome, new HashSet<String>());
                    }
                    expectings.get(palindrome).add(word);
                }
            }

            for (String match : matches) {
                System.out.println(word + "->" + match);
            }
            processed.add(word);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();

        words.add("abc");
        words.add("cba");  //find in expectings map


        words.add("xy");
        words.add("yxb"); //find in processed set


        words.add("ijj");
        words.add("i"); //find in expectings map

        words.add("mn");
        words.add("ccnm"); //find in processed map

        words.add("11");
        words.add("1");

        find(words);
    }
}
