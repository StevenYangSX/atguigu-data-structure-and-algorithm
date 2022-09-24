package com.steven.learning.javastrings;


import java.util.Locale;

/*
    1. String 是 引用数据类型
    2. 声明String的时候，使用双引号  ： String str = "test.....";
    3. String可以和8种基本数据类型做运算，且运算只能是连接运算 +   运算结果仍然为 String 类型
 */
public class StringObject {
    public static void main(String[] args) {
        //string的初始化
        // 1. 直接赋值 :  数据存储在方法区的常量池中
        String str1 = "javaEE";
        String str2 = "javaEE";
        System.out.println("str1和str2====>" + (str1 == str2 ? "相等" : "不相等"));
        // 2. new String()
        String str3 = new String("javaEE");
        String str4 = new String("javaEE");
        System.out.println("str3和str4====>" + (str3 == str4 ? "相等" : "不相等"));

        // 当使用 字面量（直接赋值）的时候，如果字符串一样，常量池只会存储一个字符串  所以地址相同
        // 当使用构造器创建的时候，每次都新建一个对象，地址值不相同


        /*
        String类的常用方法
         */
        String s1 = "HelloWorlD";
        System.out.println("str.length() ==> " + s1.length());
        System.out.println("str.charAt() ==> " + s1.charAt(3));
        System.out.println("str.isEmtpy() ==> " + s1.isEmpty());
        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();
        // toLowerCase()  返回一个变换后的string   原string不变 ： immutable
        System.out.println("s1 ==> " + s1);
        System.out.println("s2 ==> " + s2);
        System.out.println("s3 ==> " + s3);

        // trim :  去除 首位 空格 ，中间空格不变
        String s4 = "  Ste  ven Y A ng  ";
        String s5 = s4.trim();
        System.out.println("s4 => " + s4);
        System.out.println("s5 => " + s5);
        System.out.println("s4 length => " + s4.length());
        System.out.println("s5 length => " + s5.length());

        // equals()
        // equalsIgnoreCase()
        // concat()
        // subString(int beginIndex)
        // subString(int beginIndex, int endIndex)
    }
}
