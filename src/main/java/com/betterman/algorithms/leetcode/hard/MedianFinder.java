package com.betterman.algorithms.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zhuangda on 3/6/16.
 */

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is
 * no middle value. So the median is the mean of the two middle value.
 *
 * Examples: [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure. double
 * findMedian() - Return the median of all elements so far. For example:
 *
 * add(1) add(2) findMedian() -> 1.5 add(3) findMedian() -> 2
 */
class MedianFinder {
    Queue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder());
    Queue<Integer> large = new PriorityQueue<Integer>();
    boolean even = true;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (even) {  //(k, k) -> (k+1, k)
            large.offer(num);
            small.offer(large.poll());
        } else { //(k+1, k) -> (k+1, k+1)
            small.offer(num);
            large.offer(small.poll());
        }
        even ^= true;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (even) {
            return (large.peek() + small.peek()) / 2.0;
        } else return small.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();