package com.steven.learning.sort;

/*
    Heap Sort   O(nlogN)

    基于tree的排序  大顶堆 小顶堆
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
    }

    public static void heapSort(int[] arr) {
        System.out.println("---------Heap Sort 堆排序----------");

    }


    /**
     * @param arr    需要排序的数组
     * @param i      非叶子节点在数组中的索引index
     * @param length 对多少个元素进行调整  length在逐步减少
     * @功能 将一个数组（对应一个二叉树）调整为一个大顶堆
     */
    public static void adjustHeap(int[] arr, int i, int length) {
//        int temp = arr[i]; // 取出当前元素的值  保存为临时变量
//        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
//            if(k+1 < length )
//        }
    }
}
