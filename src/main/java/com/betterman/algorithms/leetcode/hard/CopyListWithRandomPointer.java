package com.betterman.algorithms.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangda on 1/16/16.
 */

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */
    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            Map<RandomListNode, RandomListNode> m = new HashMap();
            RandomListNode dummy = new RandomListNode(0);
            RandomListNode n = new RandomListNode(head.label);
            dummy.next = n;

            while (true) {
                if (head.next != null) {
                    if (m.containsKey(head.next)) {
                        n.next = m.get(head.next);
                    } else {
                        n.next = new RandomListNode(head.next.label);
                        m.put(head.next, n.next);
                    }
                }

                if (head.random != null) {
                    if (m.containsKey(head.random)) {
                        n.random = m.get(head.random);
                    } else {
                        n.random = new RandomListNode(head.random.label);
                        m.put(head.random, n.random);
                    }
                }

                if (head.next == null) break;
                else {
                    head = head.next;
                    n = n.next;
                }
            }

            return dummy.next;

        }
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
