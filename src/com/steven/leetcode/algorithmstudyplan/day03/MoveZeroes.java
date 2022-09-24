package com.steven.leetcode.algorithmstudyplan.day03;


/*
    Question 283. Move Zeroes

    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
 */

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println("BEFORE=====> " + Arrays.toString(nums));
        // moveZeroes(nums);
        moveZeroes2(nums);
        System.out.println("AFTER=====> " + Arrays.toString(nums));
    }

    // 仍然使用 2-pointers的方法： 但是这里注意！  所谓的 2-pointers 并不是必须要 一个真正的left 和 right 。 我们可以用这两个去track需要的位置
    //  通常， 题目中的条件 就是这两个位置   left：左边起第一个是0的元素  right：左边起第一个不是0的元素
    //  如果  right不为0   那么和left交换位置   right left 右移
    //  如果  right为0 right右移
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right <= nums.length - 1) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
    }


    /*
     结题思路
     1. 如果不对速度和空间有要求  那么最直接的方式就是 复制一个arr，通过遍历原数组，将不为0的数字分别加入新arr。然后通过counter of 0's 。 将剩余的位置填满0
     2. 但是题目要求了: Note that you must do this in-place without making a copy of the array. 不能使用新的空间复制arr  所以要优化
     3. 优化方式：
        (1). 题目可以理解为：将不为0的元素移动至数组前方，并保持相对的顺序
        (2). curr  ：  processing new elements， 如果新元素  不为0   那么 we record it just after the last found non-0 element
        (3). lastNonZeroFoundAt:  The position of last found non-0 element
        (4).
     */

    public static void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt++;
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
