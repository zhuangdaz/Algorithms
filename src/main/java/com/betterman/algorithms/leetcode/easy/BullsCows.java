package com.betterman.algorithms.leetcode.easy;

/**
 * Created by zhuangda on 1/8/16.
 */

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * For example:
 * <p>
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * <p>
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsCows {
    public class Solution {
        //"1122 1222" => 3A0B
        // "23 32" => 0A2B
        public String getHint(String secret, String guess) {
            int bulls = 0, cows = 0;
            int[] counts = new int[10];
            char[] s = secret.toCharArray();
            char[] g = guess.toCharArray();

            for (int i = 0; i < s.length; i++) {
                if (s[i] != g[i]) {
                    int si = s[i] - '0';
                    int gi = g[i] - '0';

                    if (counts[si] < 0) cows++;
                    if (counts[gi] > 0) cows++;
                    counts[si]++;
                    counts[gi]--;
                } else {
                    bulls++;
                }
            }

            return bulls + "A" + cows + "B";
        }
    }
}
