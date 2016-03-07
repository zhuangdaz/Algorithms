package com.betterman.algorithms.leetcode.hard;

/**
 * Created by zhuangda on 3/6/16.
 */
public class Candy {
    public class Solution {
        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            int candy = 1, prev = 1;
            int countDown = 0;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] >= ratings[i - 1]) {
                    if (countDown > 0) {
                        candy += (countDown + 1) * countDown / 2;
                        if (countDown >= prev) {
                            candy += countDown - prev + 1;
                        }
                        countDown = 0;
                        prev = 1;
                    }

                    prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1;
                    candy += prev;
                } else {
                    countDown++;
                }
            }

            if (countDown > 0) {
                candy += (countDown + 1) * countDown / 2;
                if (countDown >= prev) {
                    candy += countDown - prev + 1;
                }
            }
            return candy;
        }
    }
}
