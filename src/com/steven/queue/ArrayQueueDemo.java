package com.steven.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {

        ArrayQueueImplEasy arrayQueue = new ArrayQueueImplEasy(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据至队列");
            System.out.println("d(dequeue):取出数据");
            System.out.println("h(check head):查看头部数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数字:");
                    int value = scanner.nextInt();
                    arrayQueue.enqueue(value);
                    break;
                case 'd':
                    try{
                        int e =  arrayQueue.dequeue();
                        System.out.printf("取出的值为 : %d\n",e);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int e =   arrayQueue.getHead();
                        System.out.printf("取出的值为 : %d\n",e);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop= false;
                    break;
                default:
                    break;
            }
        }
    }


}
