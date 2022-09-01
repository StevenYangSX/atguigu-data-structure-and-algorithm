package com.steven.doublylinkedlist;

public class DoublyLinkedList {

    private Node head = new Node(0,"");

    public Node getHeader() {
        return head;
    }

    //遍历双向链表
    public void traverse() {
        if(head.next == null ) {
            System.out.println("链表为空~~~");
            return;
        }

        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }


    //添加节点至链表最后
    public void insertToLast(Node node) {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;

    }

    //修改一个节点的内容
    public void update(Node node) {
        if(head.next== null) {
            System.out.println("链表为空~~无法修改");
            return;
        }
        Node temp = head.next;
        boolean nodeFound = false;
        while(temp != null) {
            if(temp.sort == node.sort) {
                nodeFound = true;
                break;
            }
            temp = temp.next;
        }
        if(nodeFound) {
            temp.name = node.name; //修改数据
        } else  {
            System.out.println("不存在sort为"+node.sort+"的节点");
        }
    }

    //删除一个节点
    // 1. 对于双向链表，我们可以直接找到要删除的节点
    // 2. 然后进行自我删除
    public void delete(int sort) {
        if(head.next == null) {
            System.out.println("链表为空~~无法删除");
            return;
        }

        Node temp = head.next;
        boolean nodeFound = false;

        while(true) {
            if(temp == null ){
                break;
            }
            if(temp.sort == sort) {
                nodeFound = true;
                break;
            }
            temp = temp.next;
        }

        if(!nodeFound) {
            System.out.println("没找到SORT值为 "+sort+" 的节点~~");
            return;
        }

        temp.prev.next = temp.next;
        //如果是最后一个节点 无需下面这行操作
        if(temp.next != null) {
            temp.next.prev = temp.prev;
        }


    }
}
















