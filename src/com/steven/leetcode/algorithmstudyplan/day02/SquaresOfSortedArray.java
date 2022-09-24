package com.steven.leetcode.algorithmstudyplan.day02;
/*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

 */

import java.util.Arrays;

/*
    1. 最简单的方法： 计算nums[]的平方  O(n);   然后进行sort   ->  O(n log(n))    这种方法的time efficient  为   O(n log(n))

    2. 利用binary search 找到0的位置 O(logN) 然后 原来的nums[] 可分为两个sub-array    [...1...] 全是负数 升序  [...2...] 全是正数 升序
        这时，利用double pointer 将1降序  2升序，计算平方 并插入新的arr   O(N)
        所以总时间 ：  O(N)   space: O(N)
    3.   ----->   method 2 better than method 1
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{-4, -1, 0, 3, 10};
        int[] arr2 = new int[]{-7, -3, 2, 3, 11};
        int[] arr3 = new int[]{-17, -13, -12, -3, -1};
        int[] arr4 = new int[]{3, 5, 7, 9, 10};
        int[] result1 = sortedSquares(arr1);
        int[] result2 = sortedSquares(arr2);
        int[] result3 = sortedSquares(arr3);
        int[] result4 = sortedSquares(arr4);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n -1; i >=0; i--) {
            if(Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[i] = nums[right] * nums[right];
                right--;
            } else {
                result[i] = nums[left] * nums[left];
                left++;
            }
        }
        return result;
    }

    public static int[] sortedSquaresMyAttemps(int[] nums) {
        // 1. find target == 0 index,
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == 0) {
                break;
            } else if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("0的index为:" + mid + "   这个就是分界线");
        //////    mid 就是分界线


        // 2. use two pointers to iterates 2 sub-arrays : negative array from tail to start. position array from start to tail
        int[] result = new int[nums.length];
        if (mid == 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) Math.pow(nums[i], 2);
            }
            return result;
        }
        if (mid == nums.length - 1) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) Math.pow(nums[nums.length - 1 - i], 2);
            }
            return result;
        }
        int goingLeft = mid;
        int goingRight = mid + 1;
        int count = 0;
        while (true) {
            if (goingLeft >= 0 && goingRight <= nums.length - 1) {
                int leftValue = nums[goingLeft] * nums[goingLeft];
                int rightValue = nums[goingRight] * nums[goingRight];
                if (leftValue <= rightValue) {
                    result[count] = leftValue;
                    result[count + 1] = rightValue;
                    count++;
                } else {
                    result[count] = rightValue;
                    result[count + 1] = leftValue;
                    count++;
                }
                goingLeft--;
                goingRight++;
            }
            if (goingLeft < 0) {
                for (; goingRight < nums.length - 1; goingRight++) {
                    result[count] = nums[goingRight] * nums[goingRight];
                    count++;
                }
                break;
            }
            if (goingRight > nums.length - 1) {
                for (; goingLeft >= 0; goingLeft--) {
                    result[count] = nums[goingLeft] * nums[goingLeft];
                    count++;
                }
                break;
            }
        }

        return result;
    }


}
