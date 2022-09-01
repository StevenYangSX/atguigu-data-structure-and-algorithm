package com.steven.sort;

import java.util.Arrays;

public class InsertionSortOptShellSort {

    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("排序前------>" + Arrays.toString(arr));

        shellSortStepByStep(arr);
    }


    /*
    这里B站讲的像粑粑   不想听了
     */
    public static void shellSortBySwap(int[] arr) {
//        int temp;
//        for (int gap = arr.length / 2 ; gap > 0; gap /= 2) {
//
//        }
    }


    /*
        个人理解版本
     */
    public static void shellSortMyImpl(int[] arr) {


    }


    // 逐步推导  ：  插入数据时，选用 交换式
    public static void shellSortStepByStep(int[] arr) {

        int temp;

        //第一轮  ：  将10个数据 分为5组   并对每组 进行 bubble sort
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮后------>" + Arrays.toString(arr));


        /*
        第二轮 ：将10个数，分为 5/2  = 2组
         */
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮后------>" + Arrays.toString(arr));

        /*
        第三轮 ： 分为 2 / 2  = 1 组
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第三轮后------>" + Arrays.toString(arr));
    }
}
