package com.steven.linkedlistimplementaion;

public class LinkedList {


    Node head;

    public LinkedList(Node head) {
        this.head = head;
        System.out.println("初始化链表成功,头节点为："+head.toString());
    }


    public Node getHead() {
        return head;
    }

    public int getLength(Node head) {
       if(head == null ) {
           System.out.println("链表不存在~~长度默认为0~~");
           return 0;
       }
       int counter = 0;
       while(head!=null) {
           counter++;
           head = head.next;
       }
        System.out.println("链表长度为："+counter);
       return counter;
    }

    public void insertToStart( Node newNode) {

        if(head == null) {
            System.out.println("链表不存在~~无法插入节点~~");
            return;
        }
        Node next = head.next;
        head.next = newNode;
        newNode.next = next;
        System.out.println("插入节点："+newNode.toString()+" 成功");
    }

    public void insertToEnd(Node node) {

    }

    public void printList(Node head) {
        if(head == null) {
            System.out.println("链表为空~~无法打印~~");
        }
        while(head != null) {
            System.out.println(head.toString());
            head = head.next;
        }
    }

    public void reverseList(Node head) {

    }

    public void printNode(Node head) {

    }

    public Node getNthNode(int n) {
        return null;
    }

    public Node getReversedNthNode(int n ) {
        return null;
    }

    public void deleteNode(Node node) {

    }



}
