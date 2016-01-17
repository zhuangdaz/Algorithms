package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhuangda on 11/16/15.
 */
public class MaxPoints {
    /**
     * Definition for a point.
     * class Point {
     * int x;
     * int y;
     * Point() { x = 0; y = 0; }
     * Point(int a, int b) { x = a; y = b; }
     * }
     */
    public static class Solution {
        public int maxPoints(Point[] points) {
            if (points.length < 3) return points.length; // 0/1/2 points
            int max = 0;
            for (int i = 0; i < points.length; i++) {
                if (points.length - i <= max) return max; //impossible to have higher number

                HashMap<String, Integer> cache = new HashMap();
                int sameCount = 0;
                int localMax = 1;
                Point p0 = points[i];
                for (int j = i + 1; j < points.length; j++) {
                    Point p1 = points[j];
                    if (p1.x == p0.x && p1.y == p0.y) {
                        sameCount++;
                    } else {
                        String ratio = getRatio(p0, p1);
                        int num;
                        if (!cache.containsKey(ratio)) {
                            num = 2;
                        } else {
                            num = cache.get(ratio) + 1;
                        }
                        cache.put(ratio, num);
                        if (num > localMax) {
                            localMax = num;
                        }
                    }
                }
                localMax += sameCount;
                if (localMax > max) {
                    max = localMax;
                }
            }
            return max;
        }

        // ax + by = 0
        private String getRatio(Point p0, Point p1) {
            int a, b;
            //vertical
            if (p0.x == p1.x) {
                a = 1;
                b = 0;
            }
            //horizontal
            else if (p0.y == p1.y) {
                a = 0;
                b = 1;
            } else {
                int dy = p0.y - p1.y;
                int dx = p0.x - p1.x;
                int gcd = gcd(Math.abs(dy), Math.abs(dx));
                a = Math.abs(dy) / gcd;
                b = Math.abs(dx) / gcd;

                if (dy * dx < 0) {
                    a *= -1;
                }
            }
            return a + "|" + b;
        }

        //ref:https://en.wikipedia.org/wiki/Euclidean_algorithm#Proof_of_validity
        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    /**
     * Definition for a point.
     * class Point {
     *     int x;
     *     int y;
     *     Point() { x = 0; y = 0; }
     *     Point(int a, int b) { x = a; y = b; }
     * }
     */
    public static class Solution2 {
        public int maxPoints(Point[] points) {
            if (points.length < 3) return points.length;

            int max = 0;
            for (int i = 0; i < points.length - 1; i++) {
                Point p0 = points[i];
                Map<String, Integer> m = new HashMap();
                int localMax = 0, same = 0;
                for (int j = i + 1; j < points.length; j++) {
                    Point p1 = points[j];
                    if (p0.x == p1.x && p0.y == p1.y) same++;
                    else {
                        String r = getRatio(p0, p1);
                        int num;
                        if (!m.containsKey(r)) num = 2;
                        else num = m.get(r) + 1;
                        m.put(r, num);
                        if (num > localMax) localMax = num;
                    }
                }
                localMax += same;
                if (localMax > max) max = localMax;
            }
            return max;
        }

        //ax + by = 0
        private String getRatio(Point p0, Point p1) {
            int a = 0, b = 0;
            //horizontal
            if (p0.y == p1.y) {
                a = 0;
                b = 1;
            }
            //vertical
            else if (p0.x == p1.x) {
                a = 1;
                b = 0;
            }
            else {
                int dx = p0.x - p1.x;
                int dy = (p0.y - p1.y) * -1;
                int gcd = gcd(Math.abs(dx), Math.abs(dy));
                a = dy / gcd;
                b = dx / gcd;
            }
            return a + "|" + b;
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(-1, -1));

        Solution2 solution = new Solution2();
        System.out.println(solution.maxPoints(points.toArray(new Point[0])));


    }

}
