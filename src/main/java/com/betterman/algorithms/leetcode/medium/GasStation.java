package com.betterman.algorithms.leetcode.medium;

/**
 * Created by zhuangda on 3/6/16.
 */
public class GasStation {
    public class Solution {
        //1.if a car starts at A and can't reach B, then any station between A and B can't reach B neither.(B is the first station A can't reach.)
        //2.if total gas amount is greater than total cast amount, then there must be a solution. Disproof: prev + gas[i] < cost[i]
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0, tank = 0, start = 0;
            for (int i = 0; i < gas.length; i++) {
                tank += gas[i] - cost[i];
                total += gas[i] - cost[i];
                if (tank < 0) {
                    tank = 0;
                    start = i + 1;
                }
            }
            return total < 0 ? -1 : start;
        }
    }
}
