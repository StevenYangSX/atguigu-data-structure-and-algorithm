package com.steven.tree;

public class ArrayBinaryTree {

    private int[] arr; //存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    //方法： 完成顺序储存二叉树的前序遍历
    public void preOrder(int index) {

        //如果数组为空  或者 arr.length 为0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空,不能遍历~~~~");
        }

        System.out.println("当前元素为:" + arr[index]);
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }

    }
}
