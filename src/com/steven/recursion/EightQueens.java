package com.steven.recursion;

public class EightQueens {

    // 定义： max为皇后数量
    int max = 8;
    // 定义： arr[]  保存皇后放置位置的结果
    int[] arr = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();


        eightQueens.check(0);
        System.out.println("共有 "+ count + " 个解法~~");
    }

    //写一个方法，可以将最后的结果 打印出来
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 当摆放好第n个皇后以后，查看是否和之前摆放的 冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //  两个元素相等： arr[i] == arr[n] : 他们在同一列
            //  两个元素在一条斜线上： Math.abs(n - i) == Math.abs(arr[n] - arr[i]) ---- why ?? how to get this ??
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    // 放置第n个皇后的方法
    private void check(int n) {
        // max个元素已经放置完成了  max从0开始
        if (n == max) {
            print();
            return;
        }
        // 未完成 ， 依次放入皇后， 并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把 当前这个皇后 n  ， 放到该行的第1列
            arr[n] = i;
            // 判断：当放置完第n个皇后到第 i 列的时候  是否冲突


            // 不冲突 ---->
            if(judge(n)) {
                // 放置 第n+1 个皇后
                check(n+1);
            }
            //  冲突的话， 继续执行， i++
        }
    }


}
