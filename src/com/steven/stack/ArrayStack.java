package com.steven.stack;



/*
    1. Stack
    2. FILO ---- 先入后出
    3. Stack分为： top    bottom
    4. 最先放入的元素 在bottom  最后放入的元素 在top
    5. 最先入栈的元素 在bottom  最先出栈的元素 在top
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top=-1;   // 栈顶： 初始化为 -1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull () {
        return top == maxSize -1 ;
    }

    public boolean isEmpty () {
        return top == -1;
    }

    public void push (int value) {
        if(isFull()) {
            System.out.println("栈满~~");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop () {
        if(isEmpty()) {
            throw new RuntimeException("栈空异常,没有数据");
        }
        int topValue = stack[top];
        top--;
        return topValue;
    }

    public void list () {
        //遍历栈， 需要从top开始显示
        if(isEmpty()){
            System.out.println("栈空~~ 无法遍历~~");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("Stack[%d] = %d\n",i,stack[i]);
        }
    }
}
