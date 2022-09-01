package com.steven.doublylinkedlist;

public class Node {
    int sort;
    String name;
    Node next;
    Node prev;
    public Node(){}

    public Node(int sort, String name) {
        this.sort = sort;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "sort=" + sort +
                ", name='" + name + '\'' +"}";
    }
}
