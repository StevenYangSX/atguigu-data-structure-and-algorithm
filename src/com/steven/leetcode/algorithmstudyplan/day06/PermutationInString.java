package com.steven.leetcode.algorithmstudyplan.day06;

import java.util.HashMap;
import java.util.HashSet;

/*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.


    Example 1:

    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
    Example 2:

    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false

 */
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ab";
        System.out.println(checkInclusion(s1, s2) ? "true" : "false");
    }

    public static boolean checkInclusion(String s1, String s2) {
        int targetLen = s1.length();
        int left = 0, right;
        while (left <= s2.length() - targetLen) {
            right = left + targetLen;
            String subStr = s2.substring(left, right);
            System.out.println("sdf--->" + subStr);
            if (isPermutation(subStr, s1)) {
                return true;
            }
            left++;
        }
        return false;
    }

    public static boolean isPermutation(String subString, String strGiven) {
        HashSet<Character> storage = new HashSet<>();
        for (int i = 0; i < strGiven.length(); i++) {
            storage.add(subString.charAt(i));
        }
        for (int i = 0; i < subString.length(); i++) {

            storage.remove(strGiven.charAt(i));
        }
        return storage.size() == 0;

    }
}
