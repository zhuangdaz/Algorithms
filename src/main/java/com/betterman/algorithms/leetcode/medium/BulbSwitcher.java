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

    /**
     * A bulb ends up on iff it is switched an odd number of times.
     *
     * Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i. So bulb
     * i ends up on if and only if it has an odd number of divisors.
     *
     * Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except when i
     * is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor
     * 6. So bulb i ends up on if and only if i is a square.
     *
     * So just count the square numbers.
     */
    public class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
}
