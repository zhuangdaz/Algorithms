package com.betterman.algorithms.leetcode.hard;

import com.betterman.algorithms.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhuangda on 1/4/16.
 */
public class MergeIntervals {
    public class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() <= 1) return intervals;
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval i1, Interval i2) {
                    return i1.start - i2.start;
                }
            });

            List<Interval> res = new ArrayList();
            for (int i = 0; i < intervals.size(); i++) {
                Interval in = intervals.get(i);

                while (i + 1 < intervals.size() && in.end >= intervals.get(i + 1).start) {
                    if (intervals.get(i + 1).end > in.end) {
                        in.end = intervals.get(i + 1).end;
                    }
                    i++;
                }
                res.add(in);
            }
            return res;
        }
    }
}
