package com.betterman.algorithms.leetcode.easy;

import com.betterman.algorithms.leetcode.common.Interval;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/6/16.
 */
public class MettingRooms {
    /**
     * Definition for an interval. public class Interval { int start; int end; Interval() { start =
     * 0; end = 0; } Interval(int s, int e) { start = s; end = e; } }
     */
    public class Solution {
        public boolean canAttendMeetings(Interval[] intervals) {
            if (intervals == null || intervals.length == 0) return true;
            int[] starts = new int[intervals.length];
            int[] ends = new int[intervals.length];

            for (int i = 0; i < starts.length; i++) {
                starts[i] = intervals[i].start;
                ends[i] = intervals[i].end;
            }

            Arrays.sort(starts);
            Arrays.sort(ends);

            for (int i = 1, j = 0; i < starts.length; i++) {
                if (starts[i] >= ends[j]) {
                    j++;
                } else return false;
            }
            return true;
        }
    }
}
