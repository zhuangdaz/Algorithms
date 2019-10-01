package com.betterman.algorithms.leetcode4.array;

import com.betterman.algorithms.leetcode.common.ListNode;

import java.util.*;

/**
 * Created by zhuangda on 10/3/17.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[]{map.get(another), i};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            max = Math.max(max, sum);
        }
        return max;
    }

    //118. Pascal's Triangle
    //essence: head and tail are all 1, newRow(j) = lastRow(j-1) + lastRow(j)
    //t:O(n2) s:O(n2)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList();
        List<Integer> row = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            allRows.add(new ArrayList(row));
        }
        return allRows;
    }

    //119. Pascal's Triangle II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int maxProfit = 0, minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    //167. Two Sum II - Input array is sorted
    public int[] twoSumSorted(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }

        return new int[]{-1, -1};
    }

    //169. Majority Element
    public int majorityElement(int[] nums) {
        int num = 0, count = 0;

        for (int n : nums) {
            if (num == n) count++;
            else if (count == 0) {
                num = n;
                count = 1;
            } else {
                count--;
            }
        }
        return num;
    }

    // 189. Rotate Array
    // t:O(n) s:O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int tmp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            lo++;
            hi--;
        }
    }

    // 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    // 414. Third Maximum Number
    public int thirdMax(int[] nums) {
        Integer max1 = null, max2 = null, max3 = null;

        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;

            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }

        return max3 == null ? max1 : max3;
    }

    // 448. Find All Numbers Disappeared in an Array
    // t:O(n) s:O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();

        if (nums == null || nums.length == 0) return res;

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0) {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // 566. Reshape the Matrix
    // t: O(rc)
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;

        if (m * n != r * c) return nums;

        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }

        return res;
    }

    // 581. Shortest Unsorted Continuous Subarray
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int len = nums.length;
        int start = -1, end = -1, max = nums[0], min = nums[len - 1];

        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);

            if (nums[i] < max) {
                end = i;
            }

            if (nums[len - 1 - i] > min) {
                start = len - 1 - i;
            }
        }

        if (start == -1) return 0;
        else return end - start + 1;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;

            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }

            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                continue;
            }

            flowerbed[i] = 1;
            n--;
        }
        return n <= 0;
    }

    // has a O(n) solution that just to find max1, max2, max3, min1 and min2
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 3] * nums[n - 2] * nums[n - 1];
        if (nums[0] >= 0 || nums[n - 1] <= 0) return max;

        max = Math.max(nums[0] * nums[1] * nums[n - 1], max);
        return max;
    }

    public double findMaxAverage(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];

            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }

    // 665. Non-decreasing Array
    // Greedy
    public boolean checkPossibility(int[] nums) {
        boolean hasChange = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (hasChange) return false;

                if (i == 1 || (i > 1 && nums[i - 2] <= nums[i])) {
                    nums[i - 1] = nums[i];
                    hasChange = true;
                } else {
                    nums[i] = nums[i - 1];
                    hasChange = true;
                }
            }
        }
        return true;
    }

    // 674. Longest Continuous Increasing Subsequence
    public int findLengthOfLCIS(int[] nums) {
        int max = 0, len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                max = Math.max(max, ++len);
            } else {
                len = 1;
            }
        }

        return max;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, areaOfIsland(grid, i, j));
                }
            }
        }

        return max;

    }

    // 695. Max Area of Island
    // t: O(mn)
    private int areaOfIsland(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + areaOfIsland(grid, i - 1, j) + areaOfIsland(grid, i + 1, j) +
                    areaOfIsland(grid, i, j - 1) + areaOfIsland(grid, i, j + 1);
        }
        return 0;
    }

    // 697. Degree of an Array
    //t:O(n) s: O(n)
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap();
        Map<Integer, Integer> idx = new HashMap();
        int maxDegree = 1, minSize = 1;

        for (int i = 0; i < nums.length; i++) {
            if (!idx.containsKey(nums[i])) {
                idx.put(nums[i], i);
                cnt.put(nums[i], 1);
            } else {
                int c = cnt.get(nums[i]) + 1;
                if (c > maxDegree) {
                    maxDegree = c;
                    minSize = i - idx.get(nums[i]) + 1;
                } else if (c == maxDegree) {
                    minSize = Math.min(minSize, i - idx.get(nums[i]) + 1);
                }
                cnt.put(nums[i], c);
            }
        }
        return minSize;
    }

    // 11. Container With Most Water
    // t:O(n) s: O(1)
    public int maxArea(int[] height) {
        int max = 0;
        int lo = 0, hi = height.length - 1;

        while (lo < hi) {
            int h = Math.min(height[lo], height[hi]);
            max = Math.max(max, h * (hi - lo));

            while (height[lo] <= h && lo < hi) lo++;
            while (height[hi] <= h && lo < hi) hi--;
        }

        return max;
    }

    // 15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if (nums[i] > 0) break;

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] > 0) break;

                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict);
    }


    public boolean wordBreak(String s, int start, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (wordDict.contains(word) && wordBreak(s, i + 1, wordDict)) {
                return true;
            }
        }
        return false;
    }

    public String alienOrder(String[] words) {
        Map<Character, LinkedList<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];

        //build graph
        for (int i = 0; i < words.length - 1; i++) {
            String w0 = words[i];
            String w1 = words[i + 1];
            int len = Math.min(w0.length(), w1.length());

            for (int j = 0; j < len; j++) {
                if (w0.charAt(j) != w1.charAt(j)) {
                    if (!graph.containsKey(w0.charAt(j))) {
                        graph.put(w0.charAt(j), new LinkedList<>());
                    }
                    graph.get(w0.charAt(j)).add(w1.charAt(j));
                    inDegree[w1.charAt(j) - 'a']++;
                    break;
                }
            }
        }

        // topological sort
        Queue<Character> queue = new LinkedList<>();
        for (Character c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            LinkedList<Character> neighbors = graph.get(c);

            if (neighbors == null) {
                break;
            }

            for (Character neighbor : neighbors) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return sb.toString();
    }

    public boolean validTree(int n, int[][] edges) {
        //build a graph
        Map<Integer, List<Integer>> graph = new HashMap<>(n);

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            List<Integer> neighbors0 = graph.getOrDefault(edge[0], new LinkedList<>());
            neighbors0.add(edge[1]);
            List<Integer> neighbors1 = graph.getOrDefault(edge[1], new LinkedList<>());
            neighbors1.add(edge[0]);

            graph.putIfAbsent(edge[0], neighbors0);
            graph.putIfAbsent(edge[1], neighbors1);
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for (int neighbor : graph.get(cur)) {
                if (queue.contains(neighbor)) {
                    return false;
                }

                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }

            }
        }
        return count == n;
    }

    public boolean validTreeUnionFind(int n, int[][] edges) {
        int[] root = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], root, size)) {
                return false;
            }
        }

        return n == edges.length + 1;
    }

    private boolean union(int x, int y, int[] root, int[] size) {
        int rx = root(x, root);
        int ry = root(y, root);

        if (rx == ry) {
            return false;
        }

        if (size[rx] < size[ry]) {
            root[rx] = ry;
            size[ry] += size[rx];
        } else {
            root[ry] = rx;
            size[rx] += size[ry];
        }
        return true;
    }

    private int root(int x, int[] root) {
        while (x != root[x]) {
            root[x] = root[root[x]];
            x = root[x];
        }
        return x;
    }

    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            size[i] = 1;
        }

        int count = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], root, size)) {
                count--;
            }
        }
        return count;
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = binarySearch(intervals, newInterval[0], false);
        int right = binarySearch(intervals, newInterval[1], true);

        int[] mergedInterval = new int[2];

        //handle out of bound
        mergedInterval[0] = Math.min(newInterval[0], intervals[left][0]);
        mergedInterval[1] = Math.max(newInterval[1], intervals[right][1]);

        int i;
        int[][] res = new int[left + intervals.length - right][2];
        for (i = 0; i < left; i++) {
            res[i] = intervals[i];
        }

        res[left] = mergedInterval;
        i = left + 1;
        for (int j = right + 1; j < intervals.length; j++, i++) {
            res[i] = intervals[j];
        }

        return res;
    }

    private int binarySearch(int[][] intervals, int num, boolean isLeft) {
        int lo = 0, hi = intervals.length - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            int val = isLeft ? intervals[mid][0] : intervals[mid][1];
            if (val == num) {
                return mid;
            } else if (val < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return isLeft ? hi : lo;
    }

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] in : intervals) {
            if (!heap.isEmpty() && in[0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(in[1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 24}, {6, 9}, {11, 24}, {24, 25}
        };
//        int[] newInterval = new int[]{2, 5};
//        System.out.println(Integer.MIN_VALUE + 1);
//        System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < 0; i++) {
            System.out.println("can it print");
        }

//        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
//        ListNode next = heap.poll();
    }
}
