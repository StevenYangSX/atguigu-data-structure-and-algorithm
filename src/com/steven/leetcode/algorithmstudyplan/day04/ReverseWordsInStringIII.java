package com.steven.leetcode.algorithmstudyplan.day04;

import java.util.Arrays;

/*
    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

    Example 1:

    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"
    Example 2:

    Input: s = "God Ding"
    Output: "doG gniD"
 */
public class ReverseWordsInStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String result = reverseWords(s);
        String result2 = reverseWordsAnswer(s);
        System.out.println("rsult---> "+result);
    }

    public static String reverseWords(String s) {
        String[] temp = s.split(" ");
        for (int i = 0; i < temp.length ; i++) {
            String str1 = helperSwap(temp[i]);
            System.out.println("1111"+str1);
            temp[i] = str1;
        }

        return String.join(" ", temp);
    }

    public static String helperSwap(String element) {
        char[] chars = element.toCharArray();
        System.out.println("chars  "+ chars[0]);
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left <= right) {
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public static String reverseWordsAnswer(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        // O(N)
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;

                // Swap   O(N/2)
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
}


/*
  这里遇到的问题是： 不清楚 JAVA String 的机制： string是不可变的   所以in-place操作并不会生效  需要使用新变量去替换原string
 */