package com.betterman.algorithms.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhuangda on 3/1/16.
 */
public class ImplementStackUsingQueue {
    class MyStack {
        private Queue<Integer> q = new LinkedList();
        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.poll());
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            q.poll();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
