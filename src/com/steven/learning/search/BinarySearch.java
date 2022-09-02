package com.steven.learning.search;

/*
 Binary Search 条件：数组必须是有序的
 */

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 100, 123, 222};

        int target = 777;
        int result = binarySearchIterative(arr,target );
        System.out.println("查看 查询" + target + "的结果：" + result);
        System.out.println("-----------------------------");
        ArrayList<Integer> result2 = binarySearchAll(arr, 0, arr.length - 1, 100);
        System.out.println("查看 查询" + target + "的结果：" + result2);
    }


    // binary search 递归实现

    /**
     * @param arr    给定的数组
     * @param left   左边的索引
     * @param right  右边的索引
     * @param target 需要查找的值
     * @return 找到了就返回 下标， 没找到返回-1
     */
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {

        //如果left > right ，说明没找到。
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 向右侧递归
        if (target > midValue) {
            return binarySearchRecursive(arr, mid + 1, right, target);
        } else if (target < midValue) {
            return binarySearchRecursive(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }


    // binary search 递归实现  升级版  找到所有的

    /**
     * @param arr    给定的数组
     * @param left   左边的索引
     * @param right  右边的索引
     * @param target 需要查找的值
     * @return 找到了就返回 下标， 没找到返回-1
     */
    public static ArrayList<Integer> binarySearchAll(int[] arr, int left, int right, int target) {

        //如果left > right ，说明没找到。
        if (left > right) {
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;
        int midValue = arr[mid];

        // 向右侧递归
        if (target > midValue) {
            return binarySearchAll(arr, mid + 1, right, target);
        } else if (target < midValue) {
            return binarySearchAll(arr, left, mid - 1, target);
        } else {
            ArrayList<Integer> result = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == target) {
                result.add(temp);
                temp--;
            }
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == target) {
                result.add(temp);
                temp++;
            }
            result.add(mid);
            return result;
        }
    }


    // binary search 迭代实现

    /**
     * @param arr    给定的数组
     * @param target 需要查找的值
     * @return 找到了就返回 下标， 没找到返回-1
     */
    public static int binarySearchIterative(int[] arr, int target) {

        //使用双指针 left  和 right
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target) {
                right = mid -1;
            }
            if(arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


}
