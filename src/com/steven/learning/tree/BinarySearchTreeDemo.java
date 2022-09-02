package com.steven.learning.tree;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int j : arr) {
            binarySearchTree.add(new TreeNode(j));
        }

        binarySearchTree.inOrder();
    }
}
