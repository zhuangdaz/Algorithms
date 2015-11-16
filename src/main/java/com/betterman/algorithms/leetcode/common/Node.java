package com.betterman.algorithms.leetcode.common;

/**
 * Created by zhuangda on 11/15/15.
 */
public class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }

    public void delete() {
        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
        }
    }

    public void insertAfter(Node preNode) {
        if (preNode == null) return;

        prev = preNode;
        next = preNode.next;

        if (preNode.next != null) preNode.next.prev = this;
        preNode.next = this;
    }
}
