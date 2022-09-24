package com.steven.learning.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class KnapsackProblem {

    public static void main(String[] args) {

        int[] weight = {1, 4, 3}; // 物品的重量
        int[] value = {1500, 3000, 2000}; //物品的价值
        int m = 4; // 背包的容量
        int n = value.length; // 物品的个数

        // v[i][j] : 表示 前i个物品中，能够装入容量为 j 的背包z中的最大价值
        int[][] v = new int[n + 1][m + 1];

        // 初始化第一行第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }


        // 根据公式  进行动态规划处理
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                //公式
                if (weight[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                    if (v[i - 1][j] < (value[i - 1] + v[i - 1][j - weight[i - 1]])) {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }


        }

        // 输出v
        System.out.println("查看V----->" + Arrays.deepToString(v));
    }
}
