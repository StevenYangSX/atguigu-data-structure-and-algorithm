package com.steven.learning.doublylinkedlist;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {

        //创建节点

        Node node1 = new Node(8,"Steven");
        Node node2 = new Node(2, "Tim");
        Node node3 = new Node(5, "XianDuoDuo");
        Node node4 = new Node(1, "Yang");

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertToLast(node1);
        doublyLinkedList.insertToLast(node2);
        doublyLinkedList.insertToLast(node3);
        doublyLinkedList.insertToLast(node4);


        doublyLinkedList.traverse();

        //修改
        Node node5  = new Node(1, "Yang---Updated");
        doublyLinkedList.update(node5);
        System.out.println("修改后-------------------------");
        doublyLinkedList.traverse();

        System.out.println("删除测试-------------------------");
        doublyLinkedList.delete(5);
        doublyLinkedList.traverse();
    }
}
