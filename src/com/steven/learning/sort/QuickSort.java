package com.steven.learning.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-9, 78, 0, 23, -567, 70};
        System.out.println("排序前---->" + Arrays.toString(arr));
        QuickSortMyImpl(arr,0,arr.length-1);
    }


    /*
    左程云课程讲解： QuickSort : Version 1 ----- 最差O(n^2)
    使用最后一个值 作为  pivot 值。 partition为2个分区
    <= pivot        > pivot
    partition完成后，将最后一个值 和 大于pivot区的第一个值 做交换。
     */
    public static void QuickSortV1 () {

    }


    /*
   左程云课程讲解： QuickSort : Version 2  ----- 最差O(n^2)
   使用最后一个值 作为  pivot 值。partition分为3个区
   <pivot     =pivot     >pivot
   partition完成后，将最后一个值 和 大于pivot区的第一个值 做交换。
    */
    public static void QuickSortV2 () {

    }

    /*
    左程云课程讲解： QuickSort : Version 3   ----- 最差O(nlogN)
    随机选取  pivot 值。partition分为3个区
    <pivot     =pivot     >pivot
    partition完成后，将最后一个值 和 大于pivot区的第一个值 做交换。
     */

    public static void QuickSortV3 (int[] arr, int left, int right) {
        if(left<right) {
            int randomNum = (int) (left + (Math.random() * (right - left + 1)));

            // Swap 过程
            int temp;
            temp = arr[randomNum];
            arr[randomNum] = arr[right];
            arr[right] = temp;

            // partition 过程
            int[] partition = partition(arr,left,right);

            // 递归
            QuickSortV3(arr,left,partition[0] -1 );
            QuickSortV3(arr,partition[1] + 1 ,right);


        }
    }

    /*
    这个partition方法  会划分整个arr  并返回一个 length为2 的数组：
    如： [13,18]   就代表： 等于pivot区域的 左边界 和 右边界
     */
    private static int[] partition(int[] arr, int left, int right) {
        return  null;
    }


    public static void QuickSortMyImpl(int[] arr, int left, int right) {
        // 选择一个pivot : 中间index的为pivot




    }
}
