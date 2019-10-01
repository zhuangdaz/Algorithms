package com.betterman.algorithms.boston.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    /**
     * time: O(n^2)
     * space: O(1)
     * note: Manacher’s Algorithm can solve it in time:O(n), space:O(n)
     * https://web.archive.org/web/20150313044313/http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int max = 1, start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len0 = expandFromCenter(s, i, i);
            int len1 = expandFromCenter(s, i, i + 1);

            int len = Math.max(len0, len1);
            if (len > max) {
                max = len;
                start = i - (len - 1) / 2;  //If cant come up with this simplification, just check if len is odd or even.
            }
        }

        return s.substring(start, start + max);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1; //note that both left and right already one index away from the intended one.
    }
}
