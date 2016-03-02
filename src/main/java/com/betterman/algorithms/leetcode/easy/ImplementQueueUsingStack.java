package com.betterman.algorithms.leetcode.easy;

import java.util.Stack;

/**
 * Created by zhuangda on 3/1/16.
 */
public class ImplementQueueUsingStack {
    class MyQueue {
        Stack<Integer> push = new Stack();
        Stack<Integer> pop = new Stack();

        // Push element x to the back of queue.
        public void push(int x) {
            if (!pop.empty()) {
                swap(pop, push);
            }
            push.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if (!push.empty()) {
                swap(push, pop);
            }
            pop.pop();
        }

        private void swap(Stack s1, Stack s2) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }

        // Get the front element.
        public int peek() {
            if (!push.empty()) {
                swap(push, pop);
            }
            return pop.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return push.empty() && pop.empty();
        }
    }
}
