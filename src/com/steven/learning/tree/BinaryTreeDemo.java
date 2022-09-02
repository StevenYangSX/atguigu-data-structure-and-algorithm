package com.steven.learning.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1, "Steven");
        Node node2 = new Node(2, "Tim");
        Node node3 = new Node(3, "Jack");
        Node node4 = new Node(4, "Lex");
        Node node5 = new Node(5, "Oho~~");

        //手动创建这个二叉树
        root.setLeft(node2);
        root.setRight(node3);

        node3.setLeft(node5);
        node3.setRight(node4);

        binaryTree.setRoot(root);
        //测试
        System.out.println("----------In Order-----------");
        binaryTree.inOrder();
        System.out.println("-----------Pre Order----------");
        binaryTree.preOrder();
        System.out.println("-----------Post Order----------");
        binaryTree.postOrder();
        System.out.println("===========Pre Order Search==========");
        binaryTree.preOrderSearch(1);
        binaryTree.inOrderSearch(211);
        binaryTree.postOrderSearch(5);
        System.out.println("===========删除前==========");
        binaryTree.preOrder();
        System.out.println("===========删除过程==========");
        binaryTree.delNode(1);
        System.out.println("===========删除后==========");
        binaryTree.preOrder();



    }
}
