package com.steven.learning.stack;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        System.out.println("-------------------------------");
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while (loop) {
            System.out.println("show:显示栈");
            System.out.println("exit:退出");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入选择:");
            key  = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    System.out.println("请输入:");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.println("出栈的数据为: "+res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序已退出-----");


    }
}
