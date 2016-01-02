package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/1/16.
 */
public class FindCelebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    public class Solution {
        public int findCelebrity(int n) {
            int candidate = 0;
            for (int i = 1; i < n; i++) {
                if (!knows(i, candidate)) {
                    candidate = i;
                }
            }

            for (int i = 0; i < n; i++) {
                if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
            }
            return candidate;
        }

        private boolean knows (int A, int B) {
            return false;
        }
    }
}
