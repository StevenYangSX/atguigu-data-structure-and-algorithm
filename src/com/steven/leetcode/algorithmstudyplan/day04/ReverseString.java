package com.steven.leetcode.algorithmstudyplan.day04;

import java.util.Arrays;

/*
    Write a function that reverses a string. The input string is given as an array of characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:

    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:

    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        System.out.println("Before--->"+ Arrays.toString(s));
        reverseString(s);
        System.out.println("After--->"+ Arrays.toString(s));
    }


    // two pointers and swap  O(1) extra space solution
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char temp;
        while(left<=right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
