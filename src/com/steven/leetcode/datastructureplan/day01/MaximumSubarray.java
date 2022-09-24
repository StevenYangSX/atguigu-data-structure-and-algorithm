package com.steven.leetcode.datastructureplan.day01;

import java.util.Arrays;

/*
    ? Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    ? A subarray is a contiguous part of an array.

    *Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

    *Example 2:
    Input: nums = [1]
    Output: 1

    *Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
 */
public class MaximumSubarray {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) {
            if (nums[0] < 0 && nums[1] < 0) {
                return Math.max(nums[0], nums[1]);
            }
            if (nums[0] > 0 && nums[1] > 0) {
                return nums[0] + nums[1];
            }
            return Math.max(nums[0], nums[1]);
        }
        int result = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int temp = maxSubArray(Arrays.copyOfRange(nums, 0, i));
            result = maxSubArray(new int[]{temp,nums[i]});
        }
        return result;
    }
}
