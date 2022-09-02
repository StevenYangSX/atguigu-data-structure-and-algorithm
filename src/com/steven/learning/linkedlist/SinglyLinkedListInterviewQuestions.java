package com.steven.learning.linkedlist;

public class SinglyLinkedListInterviewQuestions {

    public static void main(String[] args) {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        HeroNode node1 = new HeroNode(1, "111");
        HeroNode node2 = new HeroNode(3, "222");
        HeroNode node3 = new HeroNode(5, "333");
        HeroNode node4 = new HeroNode(7, "444");
        HeroNode node5 = new HeroNode(12, "555");
        HeroNode node6 = new HeroNode(13, "666");

        singlyLinkedList.insert(node1);
        singlyLinkedList.insert(node2);
        singlyLinkedList.insert(node3);
        singlyLinkedList.insert(node4);
        singlyLinkedList.insert(node5);
        singlyLinkedList.insert(node6);

        singlyLinkedList.show();


        System.out.println("--------------------- 一些面试题 -----------------------");
        // 1.  获取链表中 有效节点的个数
        System.out.println("---------------------1. 获取链表中有效节点的个数 -----------------------");
        int count = Solution.getNodeCount(singlyLinkedList);
        System.out.println("链表中有 " + count + " 个节点");
        System.out.println("---------------------------2.  获取链表中 倒数第N个节点的信息---------------------------");

        // 2.  获取链表中 倒数第N个节点的信息
        int target = 2;
        try {
            HeroNode reverseNthNode = Solution.getNthReverseNode(singlyLinkedList, target);
            System.out.println("倒数第" + target + "个节点是：" + reverseNthNode.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // 3.  反转链表：
        System.out.println("--------------------------- 3. 链表反转 ---------------------------");
        HeroNode newHead = Solution.reverseLinkedListInteractive(singlyLinkedList.getHead());
        singlyLinkedList.setHead(newHead);
        singlyLinkedList.show();
        int count2 = Solution.getNodeCount(singlyLinkedList);
        System.out.println("反转的链表中有 " + count2 + " 个节点");
//        System.out.println(newHead.toString());
//        System.out.println(newHead.next.toString());
//        System.out.println(newHead.next.next.toString());
//        System.out.println(newHead.next.next.next.toString());



    }
}

class Solution {

    /*
     *   @param  head
     *   @return number of nodes in the linked list
     */
    public static int getNodeCount(SinglyLinkedList linkedList) {
        int count = 0;
        HeroNode temp = linkedList.getHead();
        if (temp.next == null) {
            return count;
        }
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static HeroNode getNthReverseNode(SinglyLinkedList linkedList, int n) {
        int length = getNodeCount(linkedList);

        HeroNode temp = linkedList.getHead().next;
        /// 为空
        if (linkedList.getHead().next == null) {
            System.out.println("链表为空！");
            return null;
        }
        // 输入n值 校验
        if (n > length || n <= 0) {
            throw new IndexOutOfBoundsException("链表不存在倒数第" + n + "个节点");
        }

        int start = 0;
        int target = length - n;

        while (start < target) {
            temp = temp.next;
            start++;
        }
        return temp;
    }

    // 反转singly linked list ..
    public static HeroNode reverseLinkedListInteractive(HeroNode head) {

        // 定义两个指针  分别记录 当前节点的前一个node 和后一个node的 地址
        //  初始值  都为 null
        HeroNode prev = null;
        HeroNode next = null;

        // 开始循环
        while (head != null) {
            // 记录当前处理节点的下一个节点的地址
            next = head.next;
            // 当前处理node的next反转
            head.next = prev;
            //  记录prev
            prev = head;
            //  移动 当前处理节点的位置 至下一个
            head = next;
        }

        return prev;
    }
}
