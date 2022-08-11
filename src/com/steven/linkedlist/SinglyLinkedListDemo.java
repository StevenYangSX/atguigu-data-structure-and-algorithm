package com.steven.linkedlist;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        //创建节点
        HeroNode node1 = new HeroNode(8,"Steven");
        HeroNode node2 = new HeroNode(2, "Tim");
        HeroNode node3 = new HeroNode(5, "XianDuoDuo");
        HeroNode node4 = new HeroNode(1, "Yang");

        // 创建LInked list
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertBySort(node1);
        singlyLinkedList.insertBySort(node2);
        singlyLinkedList.insertBySort(node3);
        singlyLinkedList.insertBySort(node4);

//        singlyLinkedList.insertBySort(node3);
        System.out.println("Before.....Update.....");
        singlyLinkedList.show();

        //updae node
        singlyLinkedList.update(new HeroNode(8,"toBeChanged..."));
        System.out.println("After.....Update.....");
        singlyLinkedList.show();

        //删除节点
        singlyLinkedList.delete(node3);
        System.out.println("After.....Delete.....");
        singlyLinkedList.show();
        singlyLinkedList.delete(node3);
        System.out.println("After.....Delete.....");
        singlyLinkedList.show();
    }
}
