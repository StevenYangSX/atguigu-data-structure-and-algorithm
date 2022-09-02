package com.steven.learning.tree;

public class BinarySearchTree {
    private TreeNode root;

    public void add(TreeNode node) {
        if (root == null) {
            root = node;

        } else {
            root.add(node);
        }
    }


    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("树为空~~无法遍历");
        }
    }
}


class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    //add tree node
    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }


    // inOrder
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }


    // 查找要删除的节点

    /**
     * @param value 希望删除/搜索的节点的值
     * @return 找到了返回该节点  没找到返回null
     */
    public TreeNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
}