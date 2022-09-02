package com.steven.learning.sort;

import java.util.Arrays;

/*
    1. 把n个待排序的元素，看成一个**有序表**，一个**无序表**。
    2. 开始的时候，有序表中有1个元素，无序表中有n-1个元素。
    3. 排序过程中，每次从无序表中，取出第一个元素。把他的**排序码**依次与有序表中的**排序码**进行比较，将它插入值有序表中的适当位置，完成排序。
    4. 如：有6个元素，则需要插入5次。   **n个元素，n-1次插入**
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1};

        System.out.println("排序前-->"+ Arrays.toString(arr));

        //insertionSortStepByStep(arr);

        insertionSort(arr);
    }


    public static  void insertionSort(int[] arr) {

        // 可知  共需要  arr.length - 1 次循环
        for (int i = 0; i < arr.length -1 ; i++) {

            // 数据备份  用于后面进行insert使用
            int insertValue = arr[i+1];
            int insertIndex = i;

            while(insertIndex>=0 &&insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
        System.out.println("排序后->>>"+ Arrays.toString(arr));
    }


    //insertion sort method 逐步讲解
    public static void insertionSortStepByStep(int[] arr) {

        /*
        第一轮：
        [101,34,119,1]   ------->   [34,101,119,1]
         */

        //定义待插入的数
        int insertValue = arr[1];
        //待插入数的索引
        int insertIndex = 0;   //arr[1]前面一个数字的index

        //给insertValue找到应该插入的位置
        // 1. insertIndex>=0   index不越界
        // 2.  insertValue < arr[insertIndex]  没找到合适的位置 仍需继续移动insertIndex
        while(insertIndex>=0 && insertValue < arr[insertIndex]) {
            // 元素依次后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 退出上面while循环时，已经找到了应该插入的位置 insertIndex+1  ， 且完成了所有元素后移
        arr[insertIndex + 1] = insertValue;

        System.out.println("第一轮插入后 ------>"+ Arrays.toString(arr));



        /*
        第二轮
         */

        insertValue = arr[2];
        //待插入数的索引
        insertIndex = 1;   //arr[1]前面一个数字的index

        //给insertValue找到应该插入的位置
        // 1. insertIndex>=0   index不越界
        // 2.  insertValue < arr[insertIndex]  没找到合适的位置 仍需继续移动insertIndex
        while(insertIndex>=0 && insertValue < arr[insertIndex]) {
            // 元素依次后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 退出上面while循环时，已经找到了应该插入的位置 insertIndex+1  ， 且完成了所有元素后移
        arr[insertIndex + 1] = insertValue;

        System.out.println("第二轮插入后 ------>"+ Arrays.toString(arr));


        /*
        第三轮
         */

        insertValue = arr[3];
        //待插入数的索引
        insertIndex = 2;   //arr[1]前面一个数字的index

        //给insertValue找到应该插入的位置
        // 1. insertIndex>=0   index不越界
        // 2.  insertValue < arr[insertIndex]  没找到合适的位置 仍需继续移动insertIndex
        while(insertIndex>=0 && insertValue < arr[insertIndex]) {
            // 元素依次后移
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 退出上面while循环时，已经找到了应该插入的位置 insertIndex+1  ， 且完成了所有元素后移
        arr[insertIndex + 1] = insertValue;

        System.out.println("第三轮插入后 ------>"+ Arrays.toString(arr));

    }
}
