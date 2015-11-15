package com.betterman.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 11/15/15.
 */

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 *
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you
 * do in this case?
 * In this case, that line should be left-justified.
 *
 * Tags: String
 */

public class TextJustification {
    public class Solution {
        /**
         * Track the words and their length in the current line
         * Go through the words
         * Check next word's length, if within maxWidth, then add it to queue and update length
         * if not, start process current line
         *  if queue's size is 1, then apply left-justification(just append spaces to the right)
         *  Otherwise, get total # of extra space and divide it with # of words - 1
         *      The quotient is # of basic space inserted between each word
         *      The remainder is # of left most sections that should should 1 more space to right.
         * Deal with last line after loop is over.
         *
         */

        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ret = new ArrayList();

            StringBuffer sb = new StringBuffer();
            List<String> q = new ArrayList();
            int len = 0;
            for (int i = 0; i < words.length; i++) {
                if (len + q.size() + words[i].length() > maxWidth) {
                    //process this line
                    int extraSpace = maxWidth - len;
                    if (q.size() == 1) {
                        sb.append(q.get(0));
                        sb.append(nSpace(extraSpace));
                    } else {
                        for (int j = 0; j < q.size(); j++) {
                            sb.append(q.get(j));
                            int spaceNum = 0;
                            if (j < q.size() - 1) {
                                spaceNum = extraSpace / (q.size() - 1);
                                if (j < extraSpace % (q.size() - 1)) {
                                    spaceNum++;
                                }
                            }
                            sb.append(nSpace(spaceNum));
                        }
                    }

                    ret.add(sb.toString());
                    sb = new StringBuffer();
                    q.clear();
                    len = 0;
                }

                q.add(words[i]);
                len += words[i].length();
            }

            //last line
            int extraSpace = maxWidth - len;
            for (int j = 0; j < q.size(); j++) {
                sb.append(q.get(j));
                if (j != q.size() - 1) {
                    sb.append(nSpace(1));
                    extraSpace--;
                } else {
                    sb.append(nSpace(extraSpace));
                }
            }
            ret.add(sb.toString());

            return ret;

        }

        private String nSpace(int n) {
            StringBuffer sb = new StringBuffer();
            while (n > 0) {
                sb.append(" ");
                n--;
            }
            return sb.toString();
        }
    }
}
