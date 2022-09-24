package com.steven.learning.divideandconquer;

public class HanoiTower {
    public static void main(String[] args) {

        // test
        hanoiTower(5, 'A', 'B', 'C');
    }

    // 汉诺塔问题 移动方案： 分治算法
    public static void hanoiTower(int num, char a, char b, char c) {

        // 如果只有1个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + " -> " + c);
        } else {

            //如果有大于等于2个盘，我们总可以看做，最下面一个盘+上面的所有盘

            //   把上面的所有盘子  由于a移动至b  中间利用了c  先把上面的盘，从A->B
            hanoiTower(num - 1, a, c, b);

            // 把最下边的盘，从A->C
            System.out.println("第"+num+"个盘从 " + a + " -> " + c);

            // 将B塔的所有盘，从B->C
            hanoiTower(num - 1, b, a, c);
        }


    }
}
