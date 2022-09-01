package com.steven.bigonotation;

public class BigONotation {


    public static void main(String[] args) {

        int[] arr = new int[]{2,45,3,13,44};
        System.out.println("排序前---------");
        for (int element:  arr  ) {
            System.out.printf("%d\f",element);
        }
        bubbleSort(arr);
        System.out.println("");
        System.out.println("排序后---------");
        for (int element:  arr  ) {
            System.out.printf("%d\f",element);
        }

    }

    // 选择排序
    public static void selectionSort(int[] arr) {

        if(arr==null || arr.length <2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j :minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        // edge case
        if(arr==null || arr.length < 2 ) {
            return;
        }
        int arrLen = arr.length;

        for (int i = arrLen -1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if(arr[j]>arr[j+1]) {
                    xOrSwap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }


    // 异或操作交换两个数的位置
    // 不使用额外变量  交换两个值的位置！
    public static void xOrSwap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}



