package com.steven.queue;

public class ArrayQueue {

        private int maxSize;  //size of the queue
        private int front;      // front index
        private int rear;       // rear index
        private int[] data;           // data storage

        //constructor with maxSize
        public ArrayQueue(int queueMaxSize) {
            maxSize = queueMaxSize;
            data = new int[maxSize];
            front = -1; //指向队列头的前一个位置
            rear = -1;  //指向队列尾部的位置（最后一个位置的index）
        }

        //判断队列是否是满的
        public  boolean isFull() {
            return rear == maxSize -1;  // 查看rear是否为maxSize - 1
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
            rear++; //rear 后移
            data[rear] = element;
        }

        //数据出队列
        public int dequeue() {
            if(isEmpty()) {
                System.out.println("队列为空");
                throw new RuntimeException("队列为空");
            }
            front++;
            return data[front];
        }


        //显示队列的所有数据
        public void showQueue() {
            if(isEmpty()) {
                System.out.println("队列为空，无法显示");
                throw new RuntimeException("队列为空，无法显示");
            }
            for (int i = 0; i < data.length; i++) {
                System.out.printf("arr[%d]=%d\f\f\n",i,data[i]);
            }
        }

        //显示数据的头部数据
        public int getHead() {
            if(isEmpty()) {
               throw new RuntimeException("队列为空, 无法查看头部数据");
            }
            return data[front+1];
        }

}
