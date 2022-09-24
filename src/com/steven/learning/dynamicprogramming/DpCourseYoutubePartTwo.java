package com.steven.learning.dynamicprogramming;

/*
 A very popular tutorial from YouTube on topic of DP
 This is part two of it, which uses Tabulation Strategy to solve problems

 * link : https://www.youtube.com/watch?v=oBt53YbR9Kk


 ! Tabulation Recipe
 ! 1. visualize the problem as a table
 ! 2. size of the table based on the inputs
 ! 3. initialize the table with default values
 ! 4. seed the TRIVIAL answer into the table
 ! 5. iterate through the table
 ! 6. fill further position based on the current position




 */

public class DpCourseYoutubePartTwo {
    public static void main(String[] args) {
        System.out.println("---------- Question 1 : Fib number -------------");
        System.out.println("Fib of 1  :  " + fibTabulation(1));
        System.out.println("Fib of 3  :  " + fibTabulation(3));
        System.out.println("Fib of 8  :  " + fibTabulation(8));
        System.out.println("Fib of 32  :  " + fibTabulation(32));
        System.out.println("---------- Question 2 : Grid Traveler -------------");
        System.out.println("Grid of 2x1  :  " + gridTravelerTabulation(2, 1));
        System.out.println("Grid of 3x3  :  " + gridTravelerTabulation(3, 3));
        System.out.println("Grid of 4x6  :  " + gridTravelerTabulation(4, 6));
        System.out.println("Grid of 12x8  :  " + gridTravelerTabulation(12, 8));
        System.out.println("---------- Question 3 : Can Sum -------------");
        System.out.println("Input of (7, new int[]{5, 3, 4})  :  " + canSum(7, new int[]{5, 3, 4}));
        System.out.println("Input of (300, new int[]{7, 14})  :  " + canSum(300, new int[]{7, 14}));
        System.out.println("test -------");
    }


    public static int fibTabulation(int n) {
        int[] table = new int[n + 3];
        table[0] = 0;
        table[1] = 1;

        for (int i = 0; i <= n; i++) {
            table[i + 1] += table[i];
            table[i + 2] += table[i];
        }
        return table[n];
    }


    public static int gridTravelerTabulation(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        table[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i + 1 <= m) table[i + 1][j] += table[i][j];
                if (j + 1 <= n) table[i][j + 1] += table[i][j];
            }
        }
        return table[m][n];
    }


    public static boolean canSum(int targetSum, int[] numbers) {
        return false;
    }
}
