package com.steven.learning.tree;

public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
    }
}
