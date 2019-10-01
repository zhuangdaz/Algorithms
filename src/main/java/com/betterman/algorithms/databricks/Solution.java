package com.betterman.algorithms.databricks;

import java.util.*;

/**
 * Created by zhuangda on 9/6/17.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    // t: O(n) s: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }

        int max = 1;
        for (int num : nums) {
            int len = 1;
            for (int n = num - 1; set.contains(n); n--) {
                set.remove(n);
                len++;
            }

            for (int n = num + 1; set.contains(n); n++) {
                set.remove(n);
                len++;
            }

            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    // t: O(n) s: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                res[0] = map.get(another);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    //t: O(n^2) s: O(1)
    //k-sum: t: O(n ^ (k -1))
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                } else if (sum > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public int removeElement(int[] nums, int target) {
        int i = 0, size = nums.length;
        while (i < size) {
            if (nums[i] == target) {
                nums[i] = nums[size - 1];
                size--;
            } else {
                i++;
            }
        }
        return size;
    }

    public void moveZeroes(int[] nums) {
        int zeroPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroPtr++] = nums[i];
            }
        }

        for (int i = zeroPtr; i < nums.length; i++) {
            if (nums[zeroPtr] != 0) nums[zeroPtr] = 0;
        }
    }

    // 665 Non-decreasing Array
    public boolean checkPossibility(int[] nums) {
        int change = 0;

        for (int i = 0; i < nums.length - 1 && change <= 1; i++) {
            // key elements: i-1, i, i+1
            if (nums[i] > nums[i + 1]) {
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                change++;
            }
        }
        return change <= 1;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 0, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return Math.max(max, len);
    }

    //11. Container With Most Water
    // contradiction proof
    // t: O(n) s: O(n)
    public int maxArea(int[] height) {
        int low = 0, hight = height.length - 1;
        int max = 0;
        while (low < hight) {
            max = Math.max(max, Math.min(height[low], height[hight]) * (hight - low));
            if (height[low] < height[hight]) {
                low++;
            } else {
                hight--;
            }
        }
        return max;
    }

    //key: pruning
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 3) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;

        if (nums[0] * 4 > target || nums[len - 1] * 4 < target) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int z1 = nums[i];
            if (z1 + nums[len - 1] * 3 < target) {
                continue;
            } else if (z1 * 4 > target) {
                break;
            }

            threeSumForFourSum(nums, target - z1, i + 1, res, z1);
        }
        return res;
    }

    private void threeSumForFourSum(int[] nums, int target, int idx, List<List<Integer>> res, int z1) {
        int len = nums.length;
        if (idx > len - 3) {
            return;
        }

        for (int i = idx; i < len - 1; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            int z2 = nums[i];
            if (z2 + nums[len - 1] * 2 < target) {
                continue;
            } else if (z2 * 3 > target) {
                break;
            }

            twoSumForFourSum(nums, target - z2, i + 1, res, z1, z2);
        }
    }

    private void twoSumForFourSum(int[] nums, int target, int idx, List<List<Integer>> res, int z1, int z2) {
        if (idx > nums.length - 2) {
            return;
        }

        int lo = idx, hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                res.add(Arrays.asList(z1, z2, nums[lo], nums[hi]));

                while (lo + 1 < hi && nums[lo + 1] == nums[lo]) lo++;
                while (hi - 1 > lo && nums[hi - 1] == nums[hi]) hi--;

                lo++;
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
    }

    //t:O(n) s:O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = nums.length - 1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }

                swap(nums, i, j);
                reverseFrom(nums, i + 1);
                return;
            }
        }

        reverseFrom(nums, 0);
    }

    public static void reverseFrom(int[] nums, int from) {
        int end = nums.length - 1;
        while (from < end) {
            swap(nums, from++, end--);
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    //33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[lo]) { //left half is sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // right half is sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = firstEqualOrGreater(nums, target);

        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, firstEqualOrGreater(nums, target + 1) - 1};
        }
    }

    private int firstEqualOrGreater(int[] nums, int target) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int[] searchRange(int[] nums, int target, int lo, int hi) {
        if (lo > hi) return new int[]{-1, -1};

        int mid = (lo + hi) / 2;

        if (nums[mid] == target) {
            int[] res = new int[2];
            int[] left = searchRange(nums, target, lo, mid - 1);
            int[] right = searchRange(nums, target, mid + 1, hi);

            if (left[1] != -1) {
                res[0] = left[0];
            } else {
                res[0] = mid;
            }

            if (right[0] != -1) {
                res[1] = right[1];
            } else {
                res[1] = mid;
            }
            return res;
        } else if (nums[mid] < target) {
            return searchRange(nums, target, mid + 1, hi);
        } else {
            return searchRange(nums, target, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        System.out.println(solution.twoSum(nums, 6));
//        System.out.println(Arrays.toString(solution.threeSum(nums)));
        System.out.println(solution.threeSum(nums));
    }
}
