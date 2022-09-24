package com.steven.leetcode.algorithmstudyplan.day01;

/*
    leetcode study-plan Day1 Q1

    question 704. Binary Search

    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.

    If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        int result = search(arr, target);
        System.out.println("测试结果->"+result);

    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2 ;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) right = mid -1;
            if(nums[mid] < target ) left = mid +1;
        }
        return -1;
    }
}
