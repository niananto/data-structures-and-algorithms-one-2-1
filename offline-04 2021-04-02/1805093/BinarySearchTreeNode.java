package com.company;

public class BinarySearchTreeNode {
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
    private int value;

    public BinarySearchTreeNode(int value) {
        left = null;
        right = null;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }
}
