package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.Node;

import java.util.HashMap;

/**
 * Created by zhuangda on 11/15/15.
 */
public class LRUCache {
    private int cap;
    private HashMap<Integer, Node> map = new HashMap();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head = new Node();
        this.tail = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node n = map.get(key);
        moveToTail(n);
        return n.value;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            moveToTail(n);
            n.value = value;
        } else {
            if (map.keySet().size() == cap) {
                Node toRemove = head.next;
                toRemove.delete();
                map.remove(toRemove.key);
                if (toRemove == tail) {
                    tail = head;
                }
            }

            Node newNode = new Node(key, value);
            addToTail(newNode);
            map.put(key, newNode);
        }

    }

    private void moveToTail(Node n) {
        if (n == tail) return;

        n.delete();
        addToTail(n);
    }

    private void addToTail(Node n) {
        n.insertAfter(tail);
        tail = n;
    }

    public static void main(String[] args) {
        //1,[set(2,1),get(2),set(3,2),get(2),get(3)]
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}
