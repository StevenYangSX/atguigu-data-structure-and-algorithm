package com.steven.queue;

/*
    Circular Queue implemented by Array
 */

class ArrayCircularQueue {

    private int maxSize;  //size of the queue
    private int front;      // 指向队列头部  队列的第一个元素  初始值为0
    private int rear;       // 指向队列尾部的后一个元素       初始值为0
    private int[] data;           // data storage


    //constructor with maxSize
    public ArrayCircularQueue(int queueMaxSize) {
        maxSize = queueMaxSize;
        data = new int[maxSize];
        front = 0; //指向队列头的前一个位置
        rear = 0;  //指向队列尾部的位置（最后一个位置的index）
    }

    //判断队列是否是满的
    public  boolean isFull() {
        return (rear + 1) % maxSize  == front;  //
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void enqueue(int element) {
        if(isFull()) {
            System.out.println("队列已满");
            return;
        }
        //插入数据
        data[rear] = element;
        //后移rear ，必须考虑取模
        rear = (rear +1) % maxSize;
    }

    //数据出队列
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        // 分析front是指向队列的第一个元素，所以先要把front对应的值，保存到临时变量。
        //  第二步，将front后移
        //  将临时保存的变量返回
        int target =data[front];
        front = (front + 1) % maxSize;
        return target;
    }


    //显示队列的所有数据
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空，无法显示");
            throw new RuntimeException("队列为空，无法显示");
        }
        // 从front开始遍历，遍历多少个元素呢？遍历maxSize个元素
        for (int i = front; i < front+ validElement() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize,data[i % maxSize]);
        }
    }
    //获取队列中的 有效的数据个数
    public int validElement() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示数据的头部数据
    public int getHead() {
        if(isEmpty()) {
            System.out.println("队列为空, 无法查看头部数据");
        }
        return data[front];
    }

}
