package com.steven.learning.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        //1. create original 2D array
        // 0 没有棋子  1 黑子  2  蓝子

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

         // print arr
        for(int[] row: chessArr1) {
            for(int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组

        //Step1: get number of non-zero elements
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j< chessArr1[0].length; j++) {
                if(chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("There are "+sum+" non-zero number in the original array.");

        //Step2: create corresponding sparse array
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //Step3: iteration 2D array, store non-zero elemnts in sparseArr
        int count = 0 ; //用于记录是第几个非零数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j< chessArr1[0].length; j++) {
                if(chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("Spare Array is : ");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }


        //将稀疏数组恢复为原始数组
        //Step1: read the first row of the sparse array, create the corresponding original arr
        int[][] orignialArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        //Step2: read other rows and columns data from the sparse array, fill up the original array
        for (int i = 0; i <sparseArr[0][2] ; i++) {
            orignialArr[sparseArr[i+1][0]][sparseArr[i+1][1]] = sparseArr[i+1][2];
        }
        System.out.println("-----original array---------");
        for(int[] row: orignialArr) {
            for(int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
