package com.betterman.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * Created by zhuangda on 3/1/16.
 */
public class MinStack {
    private Stack<Integer> s = new Stack();
    private Stack<Integer> min = new Stack();

    public void push(int x) {
        s.push(x);
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int x = s.pop();
        if (min.peek() == x) {
            min.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
