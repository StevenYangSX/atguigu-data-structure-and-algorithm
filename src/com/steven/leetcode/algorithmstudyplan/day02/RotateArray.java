package com.steven.leetcode.algorithmstudyplan.day02;

import java.util.Arrays;

/*
    189. Rotate Array

    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{-1, -100, 3, 99};
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        int k = 3;
        System.out.println("before->" + Arrays.toString(nums));
        //rotate(nums, k);
        rotateOpt(nums, k);
        System.out.println("after->" + Arrays.toString(nums));
    }

    // 完成一种解法：这里需要O(N)的space 以及 O(N)的效率 ---->   提升
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            //result[i] = nums[(i+k) % nums.length];

            result[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

    }


    // 节省空间的算法： O(N) time        O(1) space    直接算好每个元素要去的位置的index  将那个index对应的值临时存储   再存至下一个未知
    public static void rotateOpt(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
