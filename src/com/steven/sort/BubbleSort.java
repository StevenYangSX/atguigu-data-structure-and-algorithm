package com.steven.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {3,9,-1,10,-2};
        System.out.println("查看原数组："+Arrays.toString(arr));
        //分解冒泡排序


        // O(n^2) 时间复杂度！
        int temp  = 0; // 临时变量
        // 外层循环
        for (int i = 0; i < arr.length -1  ; i++) {
            // 第一次循环

            for (int j = 0; j < arr.length -1 - i ; j++) {
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第"+i+"个循环后的数组："+ Arrays.toString(arr));
        }


//        //第二次循环  把第二大的数字 排列至倒数第二位
//        for (int j = 0; j < arr.length -1-1 ; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第二个循环后的数组："+ Arrays.toString(arr));
//
//        //第三次循环  把第三大的数字 排列至倒数第三位
//        for (int j = 0; j < arr.length -1-1-1; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第三个循环后的数组："+ Arrays.toString(arr));
//
//        //第四次循环  把第四大的数字 排列至倒数第四位
//        for (int j = 0; j < arr.length -1-1-1-1; j++) {
//            if(arr[j] > arr[j+1]) {
//                temp = arr[j];
//                arr[j] = arr[j+1];
//                arr[j+1] = temp;
//            }
//        }
//        System.out.println("第四个循环后的数组："+ Arrays.toString(arr));
    }
}
