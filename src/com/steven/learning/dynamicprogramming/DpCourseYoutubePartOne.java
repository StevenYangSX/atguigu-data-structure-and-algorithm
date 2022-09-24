package com.steven.learning.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

/*
 A very popular tutorial from YouTube on topic of DP

 https://www.youtube.com/watch?v=oBt53YbR9Kk

 */
public class DpCourseYoutube {
    public static void main(String[] args) {

        // First example
        System.out.println(fib(6));
        System.out.println(fib(7));
        //System.out.println(fib(50));  这里需要2^50 function call  太慢了 需要优化！
        HashMap<Integer, Integer> memo = new HashMap<>();
        int result = fibMemo(30, memo);
        System.out.println(result);

        int result1 = gridTraveler(5, 3);
        System.out.println("GridTraveller with 2,3 ==> " + result1);
        // GridTraveler with Memo
        HashMap<String, Integer> gridMemo = new HashMap<>();
        System.out.println("GridTraveller with 6,6 ==> " + gridTravelerMemo(6, 6, gridMemo));
        System.out.println("GridTraveller with 16,8 ==> " + gridTravelerMemo(16, 8, gridMemo));

        // canSum Question
        HashMap<Integer, Boolean> canSumMemo = new HashMap<>();
        System.out.println("Can Sum ===>" + (canSumMemo(300, new int[]{7, 14}, canSumMemo) ? "True" : "False"));


        System.out.println("----------------------- Question 4 : howSum Question -----------------------");
        System.out.println(Arrays.toString(howSum(7, new int[]{5, 3, 4, 7})));
    }

    // ---------- QUESTION 1 ---------------      Fib Nubmer
    /*
        Time : O(2^n)   ===> 因为Recursive, 每次都在double   1 -  2  - 4 - 8 - ....
        Space: O(n)  !!!!   这里不是 O(2^n) ！  因为所有recursive call，到最后base case的时候，都会返回。释放 call stack
     */
    public static int fib(int n) {
        // Base Case
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /* Memoization ： 使用空间，记录之前function call的值
     Time : O(n)  Space: O(n)
    */
    public static int fibMemo(int n, HashMap<Integer, Integer> memo) {
        if (n <= 2) return 1;
        if (memo.containsKey(n)) {
            return memo.getOrDefault(n, 0);
        }
        memo.put(n, fibMemo(n - 1, memo) + fibMemo(n - 2, memo));
        return memo.getOrDefault(n, 0);
    }


    // ---------- QUESTION 2 ---------------      GridTraveler
    /*
    Grid Traveler (m,n)   :  travel 2D-array from left-top to bottom-right only whit DOWN/RIGHT movement.
                             How many ways ?

    Time: O(2^m+n)
    Space: O(n+m)

     */
    public static int gridTraveler(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    public static int gridTravelerMemo(int m, int n, HashMap<String, Integer> gridMemo) {
        String key = String.valueOf(m) + ',' + String.valueOf(n);
        if (gridMemo.containsKey(key)) {
            return gridMemo.get(key);
        }
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        gridMemo.put(key, gridTravelerMemo(m - 1, n, gridMemo) + gridTravelerMemo(m, n - 1, gridMemo));
        return gridMemo.getOrDefault(key, 0);
    }


    // ---------- QUESTION 3 ---------------      canSum
    /*
    ? Question: Write a function canSum(targetSum, numbers) that takes in a targetSum and an array of numbers as arguments
    ? The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers
    ? from the array [numbers]

    * You may use element from array as many times as you want
    * All inputs numbers are non-negative
    * e.g   canSum( 7, [5,3,4,7] ) ==> True  as :  3+4=7
     */

    // Basic Solution Time O(n^m)   Space O(m)
    public static boolean canSum(int targetSum, int[] numbers) {
        // Base Case
        if (targetSum == 0) return true;
        // Go too far
        if (targetSum < 0) return false;

        for (Integer element : numbers) {
            int remainder = targetSum - element;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    // Use memo, Time O(m*n)        Space O(m)
    public static boolean canSumMemo(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
        // get result from memo
        if (memo.containsKey(targetSum)) return memo.get(targetSum);

        // Base Case
        if (targetSum == 0) return true;
        // Go too far
        if (targetSum < 0) return false;

        for (Integer element : numbers) {
            int remainder = targetSum - element;
            if (canSumMemo(remainder, numbers, memo)) {
                // Store result to memo
                memo.put(remainder, true);
                return true;
            }
        }

        // Store result to memo
        memo.put(targetSum, true);
        return false;
    }


    // ---------- QUESTION 4 ---------------      howSum
    /*
    ? Write a function howSum( targetSum , numbers ) that takes in a targetSum and array of numbers as arguments
    ? The function should return an array consisting any combination of elements that add up to exactly the targetSum
    ? If there's no combination, return null
    * If there are many combinations, you may return any single one

    * example   howSum( 8, [2,3,5] )       --------->       [2,2,2,2]   or   [3,5]
     */

    public static int[] howSum(int targetSum, int[] numbers) {
        //base case
        if (targetSum == 0) return new int[0];
        if (targetSum <= 0) return null;

        for (Integer element : numbers) {
            int remainder = targetSum - element;
            int[] result = howSum(remainder, numbers);

            // found any solution
            if (result != null) {
                int size = result.length;
                int[] temp = Arrays.copyOf(result, size + 1);
                temp[size] = element;
                return temp;
            }
        }
        return null;
    }


}
