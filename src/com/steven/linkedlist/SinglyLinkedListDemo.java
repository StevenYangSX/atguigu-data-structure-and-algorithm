package com.steven.linkedlist;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        //创建节点
        HeroNode node1 = new HeroNode(1,"Steven");
        HeroNode node2 = new HeroNode(2, "Tim");
        HeroNode node3 = new HeroNode(3, "XianDuoDuo");
        HeroNode node4 = new HeroNode(4, "Yang");

        // 创建LInked list
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insert(node1);
        singlyLinkedList.insert(node2);
        singlyLinkedList.insert(node3);
        singlyLinkedList.insert(node4);

        singlyLinkedList.show();
    }
}
