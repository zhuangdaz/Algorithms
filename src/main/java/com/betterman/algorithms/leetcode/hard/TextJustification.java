package com.betterman.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 11/15/15.
 */

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * <p>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * Note: Each word is guaranteed not to exceed L in length.
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you
 * do in this case?
 * In this case, that line should be left-justified.
 * <p>
 * Tags: String
 */

public class TextJustification {
    public static class Solution {
        /**
         * Track the words and their length in the current line
         * Go through the words
         * Check next word's length, if within maxWidth, then add it to queue and update length
         * if not, start process current line
         * if queue's size is 1, then apply left-justification(just append spaces to the right)
         * Otherwise, get total # of extra space and divide it with # of words - 1
         * The quotient is # of basic space inserted between each word
         * The remainder is # of left most sections that should should 1 more space to right.
         * Deal with last line after loop is over.
         */

        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ret = new ArrayList();

            for (int i = 0, w; i < words.length; i = w) {
                int len = -1;
                for (w = i; w < words.length && len + 1 + words[w].length() <= maxWidth; w++) {
                    len = len + 1 + words[w].length();
                }

                int space = 1, extra = 0;

                if (w != i + 1 && w != words.length) {
                    space += (maxWidth - len) / (w - i - 1);
                    extra = (maxWidth - len) % (w - i - 1);
                }

                StringBuffer sb = new StringBuffer(words[i]);
                for (int j = i + 1; j < w; j++) {
                    sb.append(nSpace(space));
                    if (extra-- > 0) sb.append(" ");
                    sb.append(words[j]);
                }

                int spaceLeft = maxWidth - sb.length();
                if (spaceLeft > 0) sb.append(nSpace(spaceLeft));
                ret.add(sb.toString());
            }
            return ret;
        }

        private String nSpace(int n) {
            StringBuffer sb = new StringBuffer();
            while (n-- > 0) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{
//            "a", "b", "c", "d", "e"
            ""
        };
        int max = 0;
        System.out.println(solution.fullJustify(words, max));
    }
}
