package com.steven.leetcode.algorithmstudyplan.day03;


import java.util.Arrays;

/*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order.
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.

    Example 1:
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]
 */
public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while (true) {
            int complement = target - numbers[left];
            if (numbers[right] == complement) {
                break;
            } else if (numbers[right] < complement) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};


        // faster solution ::::   why ???
        /*

        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};

         */


    }
}
