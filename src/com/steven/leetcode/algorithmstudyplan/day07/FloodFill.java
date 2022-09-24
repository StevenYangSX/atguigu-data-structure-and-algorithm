package com.steven.leetcode.algorithmstudyplan.day07;


import java.util.Arrays;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
Return the modified image after performing the flood fill.

Example 1

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

 */
public class FloodFill {
    public static void main(String[] args) {


        //Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        //Output: [[2,2,2],[2,2,0],[2,0,1]]

        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = floodFill(image, 1, 1, 2);
        System.out.println("After---->>>  " + Arrays.deepToString(result));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // 如果新的颜色 和以前的颜色相同  则什么都不需要做
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor) {

        // 不变化的情况： 颜色不同  or  index 越界
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        // 先将指定的 sr sc的颜色变为newColor
        image[sr][sc] = newColor;

        // recursive call : 4个方向
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
    }
}
