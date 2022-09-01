package com.steven.linkedlist;

public class SinglyLinkedList {

    //初始化一个头节点
    private HeroNode head = new HeroNode(0, "");

    public void setHead(HeroNode head) {
        this.head = head;
    }

    public HeroNode getHead() {
        return head;
    }

    //添加节点方法 : 添加至linked list最后
    // 当不考虑编号的顺序时，找到当前链表的最后的一个节点，将最后节点的next 指向新的node
    public void insert(HeroNode node) {

        // 注意！ linked list的头节点不允许改变，所以各种操作 我们都需要一个辅助节点
        HeroNode dummyNode = head;
        //  遍历链表
        while (true) {
            if (dummyNode.next == null) {
                break;
            }
            dummyNode = dummyNode.next;
        }

        //当退出此white循环的时候，dummyNode就指向了链表的最后
        dummyNode.next = node;
    }


    /*
     Insert by sort number  -----   order by asc
      添加节点方法 : 添加至linked list中，根据sort number 进行排序 ， 排序规则：升序
     */
    public void insertBySort(HeroNode node) {
        //Head不允许动，需要一个辅助node 来帮助找到添加的位置，这个node应该位于，即将添加的位置的前一个节点

        //初始位置：HeroNode temp = head;
        HeroNode temp = head;
        boolean flag = false;  //标识：sort 值是否已经存在 初始为false
        while (true) {
            //当temp已经位于链表最后了
            if (temp.next == null) {
                break;
            }
            if (temp.next.sort > node.sort) {
                // 如果当前temp.next.sort值 大于被插入的node.sort, 那么说明 已经找到了正确的位置
                //  插入新node 至temp.next 这个位置
                break;
            } else if (temp.next.sort == node.sort) {
                // sort已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("sort已经存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }


    }


    /*
        修改节点的信息：根据编号sort 来修改.
     */

    public void update(HeroNode node) {

        // 判断是否为空
        if(head.next == null ) {
            System.out.println("链表为空,无法修改");
            return;
        }
        // 找到需要修改的node: 遍历 traverse  需要一个temp
        HeroNode temp = head.next;
        boolean flag = false; //是否找到

        while (true) {
            if(temp == null) {
                //到达链表尾部
                break;
            }
            if(temp.sort == node.sort) {
                // 找到了需要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.name = node.name; //修改数据
        } else  {
            System.out.println("不存在sort为"+node.sort+"的节点");
        }
    }

    /*
        删除节点  delete node
     */
    public void delete(HeroNode node) {
        HeroNode temp = head;
        if(temp.next == null) {
            System.out.println("链表为空，无法删除...");
            return;
        }

        boolean flag = false; //是否找到待删除的节点
        while(true) {
            if(temp.next == null ) {
                break;
            }
            if(temp.next.sort == node.sort) {
                //找到了需要删除的节点 的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到需要删除的节点..");
        }
    }

    //显示链表
    public void show() {
        // 1. 先判断 链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        HeroNode dummyNode = head.next; //这里有next 是因为上面判断了不为空 那么 .next 为下一个节点

        //System.out.println(dummyNode.toString());
        while (dummyNode != null) {
            System.out.println(dummyNode.toString());
            dummyNode = dummyNode.next;
        }

    }
}
