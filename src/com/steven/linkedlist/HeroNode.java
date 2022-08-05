package com.steven.linkedlist;

public class HeroNode {
    int sort;
    String name;
    HeroNode next;

    public HeroNode(int sort, String name) {
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
