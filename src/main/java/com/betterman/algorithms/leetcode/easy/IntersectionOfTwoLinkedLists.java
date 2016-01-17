package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.ListNode;

/**
 * Created by zhuangda on 1/17/16.
 */
public class IntersectionOfTwoLinkedLists {
    public class Solution {
        //calculate the length of each lists
        //forward head of the longer list to a node from where has the same length as the shorter list
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0, lenB = 0;
            ListNode nA = headA;
            ListNode nB = headB;

            while (nA != null) {
                lenA++;
                nA = nA.next;
            }

            while (nB != null) {
                lenB++;
                nB = nB.next;
            }

            nA = headA;
            nB = headB;
            if (lenA < lenB) {
                nB = forward(headB, lenB - lenA);
            } else {
                nA = forward(headA, lenA - lenB);
            }

            while (nA != null) {
                if (nA == nB) return nA;
                nA = nA.next;
                nB = nB.next;
            }
            return null;
        }

        private ListNode forward(ListNode head, int n) {
            while(n > 0) {
                head = head.next;
                n--;
            }
            return head;
        }


        public ListNode getIntersectionNodeConcise(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;

            while(pA != pB) {
                pA = pA.next;
                pB = pB.next;

                if (pA == pB) return pA; //in case of pA == pB == null
                if (pA == null) pA = headB;
                if (pB == null) pB = headA;
            }
            return pA;
        }
    }
}
