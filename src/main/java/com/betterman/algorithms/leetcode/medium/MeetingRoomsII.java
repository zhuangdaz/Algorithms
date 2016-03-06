package com.betterman.algorithms.leetcode.medium;

import com.betterman.algorithms.leetcode.common.Interval;

import java.util.Arrays;

/**
 * Created by zhuangda on 3/5/16.
 */

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 *
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRoomsII {
    public class Solution {
        //O(nlgn)
        public int minMeetingRooms(Interval[] intervals) {
            int n = intervals.length;
            int[] starts = new int[n];
            int[] ends = new int[n];

            for (int i = 0; i < n; i++) {
                starts[i] = intervals[i].start;
                ends[i] = intervals[i].end;
            }

            Arrays.sort(starts);
            Arrays.sort(ends);

            //endItr points to next available room's ending time
            //if next meeting's start time is equal or greater than it, then no need to increase room
            //otherwise, increase room to hold the next meeting.
            int rooms = 0;
            int endItr = 0;
            for (int i = 0; i < n; i++) {
                if (starts[i] < ends[endItr]) rooms++;
                else endItr++;
            }

            return rooms;
        }
    }
}
