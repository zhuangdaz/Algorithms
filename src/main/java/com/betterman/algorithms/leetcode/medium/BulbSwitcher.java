package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 1/24/16.
 */

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off
 * every second bulb. On the third round, you toggle every third bulb (turning on if it's off or
 * turning off if it's on). For the nth round, you only toggle the last bulb. Find how many bulbs
 * are on after n rounds.
 */
public class BulbSwitcher {
    //only num which is a square is on.
    public class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
}
