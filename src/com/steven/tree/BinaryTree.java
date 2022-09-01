package com.steven.tree;

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前前树为空,无法遍历");
        }
    }

    public void inOrder() {
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("当前树为空,无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前树为空,无法遍历");
        }
    }

    public void preOrderSearch(int num) {
        if (this.root != null) {
            Node result = this.root.preOrderSearch(num);
            if (result != null) {
                System.out.println("找到的节点为->" + this.root.preOrderSearch(num).toString());
            } else {
                System.out.println("没找到啊~~~~");
            }
        } else {
            System.out.println("当前树为空,无法查找");
        }
    }

    public void inOrderSearch(int num) {
        if(this.root != null) {
            Node result = this.root.inOrderSearch(num);
            if (result != null) {
                System.out.println("找到的节点为->" + this.root.inOrderSearch(num).toString());
            } else {
                System.out.println("没找到啊~~~~");
            }
        } else {
            System.out.println("当前树为空,无法查找");
        }
    }

    public void postOrderSearch(int num) {
        if(this.root != null) {
            Node result = this.root.postOrderSearch(num);
            if (result != null) {
                System.out.println("找到的节点为->" + this.root.postOrderSearch(num).toString());
            } else {
                System.out.println("没找到啊~~~~");
            }
        } else {
            System.out.println("当前树为空,无法查找");
        }
    }


    // 删除节点
    public void delNode( int num ) {
        if(root != null ) {
            // 只有一个root节点
            if(root.getNum() == num) {
                root = null;
            } else {
                root.delNode(num);
            }
        } else {
            System.out.println("空树！无法删除~~~~");
        }
    }
}


class Node {
    private int num;
    private String name;
    private Node left;
    private Node right;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }


    // 前序遍历方法
    public void preOrder() {
        System.out.println("输出当前节点->" + this);
        //递归向左
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历方法
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println("输出当前节点->" + this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    // 后序遍历方法
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println("输出当前节点->" + this);
    }



    /*
    查找方法： search
     */

    // 前序   preOrder

    /**
     * @param num 要查找的号码
     * @return 如果找到，返回该节点  如果没有 返回null
     */
    public Node preOrderSearch(int num) {
        if (this.num == num) {
            return this;
        }
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(num);
        }
        return resNode;
    }

    // inorder search
    public Node inOrderSearch(int num) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.inOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.num == num) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.inOrderSearch(num);
        }
        return resNode;

    }

    //post order search
    public Node postOrderSearch(int num) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(num);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.num == num) {
            return this;
        }
        return null;
    }



    // 删除节点
    public void delNode (int num ) {
        if(this.left != null && this.left.num == num ) {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.num == num ) {
            this.right = null;
            return;
        }
        // 向左递归
        if(this.left != null) {
            this.left.delNode(num);
        }
        // 向右递归
        if(this.right != null ) {
            this.right.delNode(num);
        }
    }
}