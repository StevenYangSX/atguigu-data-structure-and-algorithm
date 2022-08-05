package com.steven.linkedlist;

public class SinglyLinkedList {

    //初始化一个头节点
    private  HeroNode head = new HeroNode(0,"");

    //添加节点方法 : 添加至linked list最后
    // 当不考虑编号的顺序时，找到当前链表的最后的一个节点，将最后节点的next 指向新的node
    public void insert(HeroNode node) {

        // 注意！ linked list的头节点不允许改变，所以各种操作 我们都需要一个辅助节点
        HeroNode dummyNode = head;
        //  遍历链表
        while(true) {
            if(dummyNode.next == null) {
                break;
            }
            dummyNode = dummyNode.next;
        }

        // 当退出此white循环的时候，dummyNode就指向了链表的最后
        dummyNode.next = node;
    }

    //显示链表
    public void show() {
        // 1. 先判断 链表是否为空
        if(head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        HeroNode dummyNode = head.next; //这里有next 是因为上面判断了不为空 那么 .next 为下一个节点
        while (true) {
            if(dummyNode == null) {
                //System.out.println(dummyNode.toString());
                break;
            }
            System.out.println(dummyNode.toString());
            dummyNode = dummyNode.next;
        }

    }
}
