package com.betterman.algorithms.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhuangda on 3/6/16.
 */

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city
 * when viewed from a distance. Now suppose you are given the locations and height of all the
 * buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed
 * by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX,
 * and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15],
 * [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2],
 * [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal
 * line segment. Note that the last key point, where the rightmost building ends, is merely used to
 * mark the termination of the skyline, and always has zero height. Also, the ground in between any
 * two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0],
 * [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000]. The input
 * list is already sorted in ascending order by the left x position Li. The output list must be
 * sorted by the x position. There must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the
 * three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5],
 * [12 7], ...]
 */
public class Skyline {
    public class Solution {
        //divide and conquer: O(nlgn)
        public List<int[]> getSkyline(int[][] buildings) {
            return getSkyline(0, buildings.length - 1, buildings);
        }

        private List<int[]> getSkyline(int lo, int hi, int[][] buildings) {
            List<int[]> res = new ArrayList();
            if (lo > hi) return res;
            else if (lo == hi) {
                int[] building = buildings[lo];
                int[] strip1 = new int[]{building[0], building[2]};
                int[] strip2 = new int[]{building[1], 0};
                res.add(strip1);
                res.add(strip2);
                return res;
            } else {
                int mid = (lo + hi) / 2;
                List<int[]> sl1 = getSkyline(lo, mid, buildings);
                List<int[]> sl2 = getSkyline(mid + 1, hi, buildings);
                List<int[]> sl = merge(sl1, sl2);
                return sl;
            }
        }

        private List<int[]> merge(List<int[]> sl1, List<int[]> sl2) {
            List<int[]> sl = new ArrayList();
            int h1 = 0, h2 = 0;
            //1.compare key points of skylines from leftmost points
            //2.choose the one has smaller x value(corner case: equal value, pick the one has higher height)
            //3.add key point p to the result, and if the other skyline last seen height h is greater than p's height, then update p's
            //height to h
            //4.repeat 1-3 until all key points are added
            //5.remove redundant key points

            int i1 = 0, i2 = 0;
            while (i1 < sl1.size() && i2 < sl2.size()) {
                int[] p1 = sl1.get(i1);
                int[] p2 = sl2.get(i2);

                if (p1[0] == p2[0]) {
                    h1 = p1[1];
                    h2 = p2[1];
                    p1[1] = Math.max(h1, h2);
                    sl.add(p1);
                    i1++;
                    i2++;
                } else if (p1[0] < p2[0]) {
                    h1 = p1[1];
                    if (h2 > p1[1]) p1[1] = h2;
                    sl.add(p1);
                    i1++;
                } else {
                    h2 = p2[1];
                    if (h1 > p2[1]) p2[1] = h1;
                    sl.add(p2);
                    i2++;
                }
            }

            while (i1 < sl1.size()) sl.add(sl1.get(i1++));
            while (i2 < sl2.size()) sl.add(sl2.get(i2++));

            Iterator<int[]> iter = sl.iterator();
            int lastHeight = 0;
            while (iter.hasNext()) {
                int[] p = iter.next();
                if (p[1] == lastHeight) iter.remove();
                lastHeight = p[1];
            }
            return sl;
        }


        public List<int[]> getSkylineHeap(int[][] buildings) {
            int[][] heights = new int[buildings.length * 2][];

            for (int i = 0; i < buildings.length; i++) {
                heights[2 * i] = new int[]{buildings[i][0], -buildings[i][2]};
                heights[2 * i + 1] = new int[]{buildings[i][1], buildings[i][2]};
            }

            Arrays.sort(heights, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });

            List<int[]> ans = new LinkedList();
            int prev = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); //max heap
            pq.add(0);

            for (int[] h : heights) {
                if (h[1] < 0) {
                    pq.add(-h[1]);
                } else {
                    pq.remove(h[1]);
                }

                int curr = pq.peek();
                if (curr != prev) {
                    ans.add(new int[]{h[0], curr});
                    prev = curr;
                }
            }
            return ans;

        }
    }
}
