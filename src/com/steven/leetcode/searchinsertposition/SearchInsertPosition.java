package com.steven.leetcode.twosum.searchinsertposition;

import org.junit.Test;

import static org.junit.Assert.*;

/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4

 */
public class SearchInsertPosition {
    @Test
    public void testcase1() {
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 5;
        int expected = 2;
        int actual = new Solution().searchInsert(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase2() {
        int[] arr = new int[]{1,3,5,6};
        int target = 2;
        int expected = 1;
        int actual = new Solution().searchInsert(arr, target);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase3() {
        int[] arr = new int[]{1,3,5,6};
        int target = 7;
        int expected = 4;
        int actual = new Solution().searchInsert(arr, target);
        assertEquals(expected, actual);
    }
}

/**
 * @requirments: O(longN) ====> binary search
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        //使用双指针 left  和 right
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid -1;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        return mid;
    }
}
