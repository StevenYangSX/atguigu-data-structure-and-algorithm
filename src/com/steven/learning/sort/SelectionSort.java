package com.steven.learning.sort;

import java.util.Arrays;


/*
    1. 从arr[0]~arr[n-1]中选出最小的数，与arr[0]进行交换。
    2. 从arr[1]~arr[n-1]中选出最小的数，与arr[1]进行交换。
    3. ........直到arr[n-2]与arr[n-1]比较，进行交换，完成排序。
    4. 总计：**n-1轮排序，每轮需要循环一次  ：O(n^2)**
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println("排序前-->"+ Arrays.toString(arr));

        //selectionSortStepByStep(arr);

        selectionSort(arr);
    }


    public static void selectionSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if(min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            // if 来优化
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println("排序后---->"+ Arrays.toString(arr));
    }

    // 选择排序方法   ------   逐步分析
    public static void selectionSortStepByStep(int[] arr) {



        //逐步推导，讲解选择排序

        /*
        第一轮    [101,34,119,1]   目标 ： --->  [1,34,119,101]
         */
        int minIndex = 0;
        int min = arr[0];
        for (int j = 1; j < arr.length; j++) {
            // 如果 min 大于   arr[j]   那么min并不是最小的  所以要重置
            if( min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        // 将最小值 和arr[0]交换
        arr[minIndex] = arr[0];
        arr[0] = min;
        System.out.println("第一轮后->"+ Arrays.toString(arr));


        /*
        第二轮
         */
        minIndex = 1;
        min = arr[1];
        for (int j = 1+1; j < arr.length; j++) {
            if( min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        // 将最小值 和arr[1]交换

        /*
        这里可以优化  如果 minIndex != 1 也就是之前定义的那个数字  才需要交换 否则无需交换
         */
        if(minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第二轮后->"+ Arrays.toString(arr));

    }
}
