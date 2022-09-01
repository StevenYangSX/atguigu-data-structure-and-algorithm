package com.steven.sort;

import java.util.Arrays;

/*
    冒泡排序是可以优化的：
    我们可以记录 "交换" 操作， 如果在一个循环内，并没有发生任何交换操作  那么其实已经完成了排序
 */

public class BubbleSortOpt {

    public static void main(String[] args) {

        int[] arr = {9, 3, 10, 99};
        System.out.println("查看原数组：" + Arrays.toString(arr));

        // O(n^2) 时间复杂度！
        int temp = 0; // 临时变量
        // 优化： 标识符： 是否存在交换操作： 如果在一个循环中  没有发生交换  既可以终止循环，已经排序完毕
        boolean flag = false;
        // 外层循环
        for (int i = 0; i < arr.length - 1; i++) {
            // 内循环
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println("第" + i + "个循环后的数组：" + Arrays.toString(arr));
            // 没发生任何交换操作
            if (!flag) {
                break;
            } else {
                // 重置 flag
                flag = false;
            }
        }
    }
}
