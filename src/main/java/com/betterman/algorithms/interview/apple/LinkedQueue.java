package com.betterman.algorithms.interview.apple;

/**
 * Created by zhuangda on 3/17/16.
 */
public class LinkedQueue {
    private class Node {
        int val;
        Node next;
    }

    Node head, tail;
    int N;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(int val) {
        Node oldTail = tail;
        tail = new Node();
        tail.val = val;
        tail.next = null;
        if (!isEmpty()) oldTail.next = tail;
        else head = tail;
        N++;
        notifyAll();
    }

    public synchronized int dequeue() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return 0;
            }
        }

        int ans = head.val;
        head = head.next;
        N--;
        return ans;
    }
}
