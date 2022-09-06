package com.steven.leetcode.algorithmstudyplan;


/*
    leetcode study-plan Day1 Q3

    278. First Bad Version

    You are a product manager and currently leading a team to develop a new product.
    Unfortunately, the latest version of your product fails the quality check.
    Since each version is developed based on the previous version, all the versions after a bad version are also bad.
    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 */
public class FirstBadVersion {

    public static void main(String[] args) {

    }

    //  binary search -----  recursive implementation

    public static int firstBadVersion(int n) {
        if(isBadVersion(n)) return n;
        
    }
}
