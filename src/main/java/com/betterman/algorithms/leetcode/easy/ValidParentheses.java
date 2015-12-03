package com.betterman.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by zhuangda on 12/2/15.
 */
public class ValidParentheses {
    public class Solution {
        //time: O(n), space:O(n)
        public boolean isValid(String str) {
            if (str == null) return false;
            Stack<Character> s = new Stack();
            Map<Character, Character> map = new HashMap();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    s.push(c);
                }
                // check stack is empty, case:"]"
                else if (s.isEmpty() || s.peek() != map.get(c)) {
                    return false;
                } else {
                    s.pop();
                }
            }
            //check stack is empty, case: "["
            return s.isEmpty();
        }
    }
}
