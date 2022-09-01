package com.steven.recursion;

public class RecursionDemo {

    // 打印---最简单的递归
    public static void test(int n ) {
        if(n > 2) {
            test(n -1);
        }
        System.out.println("n = " + n);
    }

    // 阶乘 --- 很简单的递归
    public static int factorial (int n) {
        if(n == 1) {
            return 1;
        } else {
            return factorial(n-1)*n;
        }
    }

    public static void main(String[] args) {
        //调用第一个递归方法
        test(4);

        //调用递归 计算阶乘的方法
        int target = 4;
        int result = factorial(target);
        System.out.println(target+"的阶乘为:"+result);
    }
}
