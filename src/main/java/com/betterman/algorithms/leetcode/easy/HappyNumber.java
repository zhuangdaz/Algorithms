package com.betterman.algorithms.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuangda on 1/9/16.
 */
public class HappyNumber {
    public class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet();

            while (n != 1) {
                int next = 0;
                while (n != 0) {
                    int d = n % 10;
                    next += d * d;
                    n /= 10;
                }
                n = next;
                if (!set.add(n)) return false;
            }
            return true;
        }

        //space: O(1)
        //idea: find loop in a linked list
        public boolean isHappySaveSpace(int n) {
            int slow = n, fast = n;
            while (fast != 1) {
                slow = cal(slow);
                fast = cal(cal(fast));
                if (slow == fast && fast != 1) return false;
            }
            return true;
        }

        private int cal(int n) {
            int next = 0;
            while (n != 0) {
                int d = n % 10;
                next += d * d;
                n /= 10;
            }
            return next;
        }
    }
}
