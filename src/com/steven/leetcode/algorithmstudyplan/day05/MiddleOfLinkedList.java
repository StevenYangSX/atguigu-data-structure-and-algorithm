package com.steven.leetcode.algorithmstudyplan.day05;


import java.util.List;

/*
    Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:

    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        ListNode curr = head;
        ListNode mid = head;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
            if (count % 2 == 0) {
                mid = mid.next;
            }
        }
        return mid;
    }


    // Solution : fast & slow pointers !
    public static ListNode fastSlowMiddleNode (ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
