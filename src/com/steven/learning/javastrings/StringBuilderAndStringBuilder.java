package com.steven.learning.javastrings;


/*
    String: 不可变字符序列  底层使用 char[] 存储value
    StringBuffer: 可变字符序列，效率低，线程安全  底层使用 char[] 存储value
    StringBuilder: 可变字符序列，效率高，线程不安全  底层使用 char[] 存储value
 */
public class StringBuilderAndStringBuilder {

    public static void main(String[] args) {

        StringBuffer sb1 = new StringBuffer("abc");
        System.out.println(sb1);
        sb1.setCharAt(1, 'X');
        System.out.println(sb1);

        // 方法
        sb1.append("UIOPE");
        System.out.println(sb1);

        sb1.append(12.233);
        System.out.println(sb1);

        sb1.delete(0,5);   // 删除   0 1 2 3 4  : 左闭右开    ( 0 , 5 ]
        System.out.println(sb1);

    }
}
