package com.betterman.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuangda on 12/3/15.
 */

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to compute all possible states of the string after one valid move.

 For example, given s = "++++", after one move, it may become one of the following states:

 [
 "--++",
 "+--+",
 "++--"
 ]
 If there is no valid move, return an empty list [].

 Company Tags Google
 Tags String
 Similar Problems (M) Flip Game II

 */
public class FlipGame {
    public class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> ret = new ArrayList();

            for (int i = 0; i < s.length() - 1; i++) {
                char c = s.charAt(i);
                if (c != '+' || s.charAt(i + 1) != '+') continue;

                String str = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                ret.add(str);
            }

            return ret;
        }
    }
}
