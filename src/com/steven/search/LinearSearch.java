package com.steven.search;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};

        System.out.println("线性查找:-1,下标为:"+linearSearch(arr,-1));

    }


    // 线性查找就是逐一比对
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
