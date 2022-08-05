package com.steven.queue;

/*
    My Implementation for Queue.
    It is better to me because :

    1. it makes more sense to initialize the front  to be 0 , and rear to be       capacity - 1
    2. it has a variable to track the size of the queue


    Operations            Time Complexity    Space Complexity
Enqueue(insertion)           O(1)
Dequeue(deletion)            O(1)
Front(Get front)             O(1)
Rear(Get Rear)               O(1)
 */
public class ArrayQueueImplEasy {

    int front;  // 队首
    int rear;   // 队尾
    int size;   // 队中存储的数据个数
    int capacity;   // 队能存储的值的最大个数
    int[] data;     // 数据存储array

    public ArrayQueueImplEasy(int capacity) {
        this.capacity = capacity;
        front = 0;  // 初始化： front 为  0
        rear = capacity - 1;  // 初始化： rear 为  （capacity -  1） ie：capacity = 10, 则尾部index为 10 - 1 = 9
        size = 0;       //初始化size为0
        data = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int item) {
        if (isFull()) {
            System.out.println("队列已满~~~~~");
            return;
        }
        rear = (rear + 1) % capacity;   // 找到即将插入元素的位置， 如果越界，需要取模  rear+1  是因为  rear = capacity - 1 ; 这里要加回去
        data[rear] = item;
        size++;
        System.out.println(item + "添加至队列~~~~");
    }

    int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空,无法提取~~~~");
        }
        int element = data[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(element + " 成功出队：");
        return element;
    }

    int getHead() {
        if(isEmpty()){
           throw new RuntimeException("队列为空，无法查看队首~~~~");
        }
        System.out.println("当前队首元素为 "+data[front]);
        return data[front];
    }

    void showQueue() {
        if(isEmpty()) {

            throw new RuntimeException("队列为空，无法显示队列~~~~~");
        }
        for (int i = 0; i <size; i++) {
            System.out.println("当前队列第 "+(i+1)+" 个元素为"+data[(front+i)%capacity]);
        }
    }

}
