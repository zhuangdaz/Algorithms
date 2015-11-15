package com.zhuangda.leetcode.medium;

/**
 * Created by zhuangda on 10/9/15.
 */
public class AddTwoNums {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //move forward one digit a time with carry until both of two lists end and carry is 0
            //O(n) runtime, O(n) space
            //corner case, two lists have different length
            ListNode head = new ListNode(0);

            ListNode next = head;
            int carry = 0;
            int left = 0;
            int right = 0;
            while (true) {
                if (l1 == null && l2 == null && carry == 0) {
                    break;
                }

                if (l1 != null) {
                    left = l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    right = l2.val;
                    l2 = l2.next;
                }

                int sum = left + right + carry;
                next.next = new ListNode(sum % 10);
                next = next.next;
                carry = sum / 10;
                left = 0;
                right = 0;
            }
            return head.next;
        }
    }
}
