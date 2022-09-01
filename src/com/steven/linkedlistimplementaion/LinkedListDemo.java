package com.steven.linkedlistimplementaion;

public class LinkedListDemo {

    public static void main(String[] args) {

        Node headNode = new Node(0);
        LinkedList testList = new LinkedList(headNode);
        Node head = testList.getHead();

        Node node1 = new Node(12);
        Node node2 = new Node(19);
        Node node3 = new Node(33);

        testList.insertToStart(node1);
        testList.insertToStart(node2);
        testList.insertToStart(node3);


        int listLength = testList.getLength(head);
        testList.printList(head);
    }
}
