package com.betterman.algorithms.leetcode2.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 3/15/16.
 */
public class LRUCache {
    int cap;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap();
        head = new Node();
        tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node n = map.get(key);
        moveToTail(n);
        return n.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            moveToTail(n);
        } else {
            if (map.size() == cap) {
                Node toRemove = head.next;
                map.remove(toRemove.key);
                toRemove.delete();
                if (toRemove == tail) tail = head;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToTail(newNode);
        }
    }

    private void moveToTail(Node node) {
        if (tail == node) return;

        node.delete();
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    class Node {
        int key;
        int val;
        Node prev, next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.val = value;
        }

        void delete() {
            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;
        }
    }
}