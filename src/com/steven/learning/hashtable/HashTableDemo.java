package com.steven.learning.hashtable;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {

        // 创建一个hash table
        HashTable hashTable = new HashTable(7);

        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:    添加雇员");
            System.out.println("list:   显示雇员");
            System.out.println("find:   查找雇员");
            System.out.println("exit:   退出");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Employee employee = new Employee(id, name);
                    hashTable.add(employee);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    int targetId = scanner.nextInt();
                    hashTable.findByid(targetId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;

            }
        }
    }
}


class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class EmployeeLinkedList {

    private Employee head;

    // 添加员工
    //  1. 添加时，添加至链表最后位置
    public void add(Employee employee) {
        // 如果要添加至第一个位置
        if (head == null) {
            head = employee;
            return;
        }
        // 如果不是第一个 使用辅助指针定位至最后
        Employee curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = employee;
    }

    // 遍历员工
    public void list(int key) {
        if (head == null) {
            System.out.println("第" + key + "链表为空~~~");
            return;
        }
        System.out.print("第" + key + "个链表的信息为:");
        Employee curr = head;
        while (curr != null) {
            System.out.printf("id=>%d name=%s\t", curr.id, curr.name);
            curr = curr.next;
        }
        System.out.println();
    }

    // 根据id查找雇员  如果找到 就返回  没找到 返回空
    public Employee findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空~~");
        }
        Employee curr = head;
        while (curr != null) {
            if (curr.id == id) {
                break;
            }
            curr = curr.next;
        }
        return curr;
    }
}


// hash table  管理多条链表
class HashTable {
    private EmployeeLinkedList[] employeeLinkedListArr;
    private int size;

    public HashTable(int size) {
        employeeLinkedListArr = new EmployeeLinkedList[size];
        this.size = size;
        // 这里有坑 初始化的时候，数组为 linked-list 数组  必须进行初始化！
        for (int i = 0; i < size; i++) {
            employeeLinkedListArr[i] = new EmployeeLinkedList();
        }
    }

    // 添加雇员
    public void add(Employee employee) {
        // 根据员工id，得到该员工应该添加到哪条链表
        int key = hashFunction(employee.id);

        // 将employee添加至对应的链表中
        employeeLinkedListArr[key].add(employee);
    }

    public void list() {
        for (int i = 0; i < employeeLinkedListArr.length; i++) {
            employeeLinkedListArr[i].list(i);
        }
    }

    // 根据输入的id 查找雇员
    public void findByid(int id) {
        int key = hashFunction(id);
        Employee employee = employeeLinkedListArr[key].findEmpById(id);
        if (employee != null) {
            System.out.println("已找到雇员-> id为" + employee.id +";名字为："+employee.name);
        } else {
            System.out.println("未找到id为" + id + "的雇员~~~");
        }
    }

    // 散列函数 hash function
    public int hashFunction(int id) {
        return id % size;
    }
}