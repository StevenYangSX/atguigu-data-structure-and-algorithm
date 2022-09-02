package com.steven.leetcode.twosum;

import org.junit.Test;

import java.util.HashMap;
import static org.junit.Assert.*;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.



    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */
public class TwoSum {

    @Test
    public void testCase1() {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] expected = new int[] {0,1};
        Solution solution = new Solution();
        int[] actual = solution.twoSum(arr,target);
        assertArrayEquals("check result->",actual,expected);
    }
    @Test
    public void testCase2() {
        int[] arr = {3,2,4};
        int target = 6;
        int[] expected = new int[] {1,2};
        Solution solution = new Solution();
        int[] actual = solution.twoSum(arr,target);
        assertArrayEquals("check result->",actual,expected);
    }
    @Test
    public void testCase3() {
        int[] arr = {3,3};
        int target = 6;
        int[] expected = new int[] {0,1};
        Solution solution = new Solution();
        int[] actual = solution.twoSum(arr,target);
        assertArrayEquals("check result->",actual,expected);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(hashMap.containsKey(diff)){
               return new int[] {hashMap.get(diff),i};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }
}
