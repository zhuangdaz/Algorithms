package com.betterman.algorithms.leetcode.hard;

import java.util.Stack;

/**
 * Created by zhuangda on 1/3/16.
 */
public class LargestRectangleInHistogram {
    public class Solution {
        public int largestRectangleArea(int[] height) {
            Stack<Integer> s = new Stack();

            int max = 0, i = 0;
            while (!s.isEmpty() || i < height.length)
            {
                if (s.isEmpty() || i < height.length && height[s.peek()] <= height[i]){
                    s.push(i++);
                } else {
                    int index = s.pop();
                    int leftIndex = s.isEmpty() ? 0 : s.peek() + 1;
                    int area = height[index] * (i - leftIndex);
                    if (area > max) max = area;
                }
            }
            return max;
        }

        // use int[] to replace stack
        public int largestRectangleAreaSelfStack(int[] height) {
            if (height.length == 0) return 0;
            int[] s = new int[height.length];

            int max = 0, top = -1;

            for (int i = 0; i <= height.length; i++) {
                int h = i == height.length ? 0 : height[i];

                while (top > -1 && height[s[top]] >= h) {
                    int index = s[top--];
                    int leftIndex = top == -1 ? 0 : s[top] + 1;
                    int area = height[index] * (i - leftIndex);
                    if (area > max) max = area;
                }

                s[++top] = i;
            }

            return max;
        }
    }
}
