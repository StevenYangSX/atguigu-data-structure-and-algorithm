package com.steven.learning.bigonotation;

public class XorOperator {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,2,2,3,3,4,4,5,5,5};
        int answer1 = findOddTimesNumber(arr);
        System.out.println("答案---->"+answer1);
        int[] answer2 = findOddTimesNumber2(arr);
        for (int i : answer2) {
            System.out.println(i);
        }

    }

    // 如果给定的arr内，只有一个出现奇数次的数字，找到这两个数字
    public static int findOddTimesNumber(int[] arr) {
        int exclusiveOr = 0;
        for (int element: arr) {
            exclusiveOr = exclusiveOr ^ element;
        }
        return exclusiveOr;
    }

    // 如果给定的arr内，只有两个出现奇数次的数字 a 和 b ，找到这两个数字
    public static int[] findOddTimesNumber2(int[] arr) {
        int exclusiveOr = 0;

        for(int element : arr) {
            exclusiveOr  = exclusiveOr ^ element;
        }
        // 经过这个loop,我们会得到： exclusive = a ^ b
        // 且： exclusive != 0 : 以为 a 和 b 不等
        // 所以可推出====> exclusive的编码中，某一位 肯定是1 不是0

        // 我们使用一下语句，提取出一个数的二进制中的最右侧的一个1的位置
        int rightOne = exclusiveOr & (~exclusiveOr + 1);

        int onlyOne = 0; // eor`

        for(int element: arr) {
            if((element & rightOne) == 0) {
                onlyOne ^=element;
            }
        }
        return new int[]{onlyOne,onlyOne ^ exclusiveOr};
    }
}
