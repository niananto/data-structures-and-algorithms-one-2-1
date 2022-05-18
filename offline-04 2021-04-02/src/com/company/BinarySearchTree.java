package com.company;

import static java.lang.Math.max;

public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public BinarySearchTreeNode getMinItem() {
        return getMinItem(root);
    }

    private BinarySearchTreeNode getMinItem(BinarySearchTreeNode currentNode) {
        while(currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    public BinarySearchTreeNode getMaxItem() {
        return getMaxItem(root);
    }

    private BinarySearchTreeNode getMaxItem(BinarySearchTreeNode currentNode) {
        while(currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }
        return currentNode;
    }

    public boolean insertItem(BinarySearchTreeNode newNode) {
//        if(currentNode == null) {
//            currentNode = newNode;
//            return true;
//        } else if(newNode.getValue() < currentNode.getValue()) {
//            return insertItem(newNode, currentNode.getLeft());
//        } else if(newNode.getValue() > currentNode.getValue()) {
//            return insertItem(newNode, currentNode.getRight());
//        } else {
//            return false;
//        }

        if(root == null) {
            root = newNode;
            return true;
        }

        BinarySearchTreeNode currentNode = root;
        while(true) {
            if(newNode.getValue() < currentNode.getValue()) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    return true;
                }
                currentNode = currentNode.getLeft();
            } else if(newNode.getValue() > currentNode.getValue()) {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    return true;
                }
                currentNode = currentNode.getRight();
            } else {
                return false;
            }
        }
    }

    public boolean searchItem(BinarySearchTreeNode findNode) {
        return searchItem(findNode, root);
    }

    private boolean searchItem(BinarySearchTreeNode findNode, BinarySearchTreeNode currentNode) {
        if(currentNode == null) {
            System.out.println(findNode.getValue() + " has not been found");
            return false;
        } else if(findNode.getValue() < currentNode.getValue()) {
            return searchItem(findNode, currentNode.getLeft());
        } else if(findNode.getValue() > currentNode.getValue()) {
            return searchItem(findNode, currentNode.getRight());
        } else {
            System.out.println(findNode.getValue() + " has been found");
            return true;
        }
    }

    public int getItemDepth(BinarySearchTreeNode findNode) {
        return getItemDepth(findNode, root, 0);
    }

    private int getItemDepth(BinarySearchTreeNode findNode, BinarySearchTreeNode currentNode, int currentDepth) {
        if (currentNode == null) {
            return -1;
        } else if (findNode.getValue() < currentNode.getValue()) {
            return getItemDepth(findNode, currentNode.getLeft(), currentDepth + 1);
        } else if (findNode.getValue() > currentNode.getValue()) {
            return getItemDepth(findNode, currentNode.getRight(), currentDepth + 1);
        } else {
            return currentDepth;
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinarySearchTreeNode currentNode) {
//        if(currentNode.getLeft() == null && currentNode.getRight() == null) {
//            return 0;
//        } else if(currentNode.getLeft() == null) {
//            return 1 + getHeight(currentNode.getRight());
//        } else if(currentNode.getRight() == null) {
//            return 1 + getHeight(currentNode.getLeft());
//        } else {
//            return 1 + max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight()));
//        }

        if(currentNode == null || currentNode.isLeaf()) {
            return 0;
        } else {
            return 1 + max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight()));
        }
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(BinarySearchTreeNode currentNode) {
//        if(currentNode.getLeft() == null && currentNode.getRight() == null) {
//            return 1;
//        } else if(currentNode.getLeft() == null) {
//            return 1 + getSize(currentNode.getRight());
//        } else if(currentNode.getRight() == null) {
//            return 1 + getSize(currentNode.getLeft());
//        } else {
//            return 1 + getSize(currentNode.getLeft()) + getSize(currentNode.getRight());
//        }

        if(currentNode == null) {
            return 0;
        } else {
            return 1 + getSize(currentNode.getLeft()) + getSize(currentNode.getRight());
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(BinarySearchTreeNode currentNode) {
        if(currentNode == null) {
            return;
        }
        printInOrder(currentNode.getLeft());
        System.out.print(currentNode.getValue() + " ");
        printInOrder(currentNode.getRight());
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(BinarySearchTreeNode currentNode) {
        if(currentNode == null) {
            return;
        }
        System.out.print(currentNode.getValue() + " ");
        printPreOrder(currentNode.getLeft());
        printPreOrder(currentNode.getRight());
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(BinarySearchTreeNode currentNode) {
        if(currentNode == null) {
            return;
        }
        printPostOrder(currentNode.getLeft());
        printPostOrder(currentNode.getRight());
        System.out.print(currentNode.getValue() + " ");
    }

    public BinarySearchTreeNode getInOrderSuccessor(BinarySearchTreeNode node) {
        BinarySearchTreeNode currentNode = root;
        BinarySearchTreeNode lastLeftTurn = null;
        while(currentNode != null) {
            if(node.getValue() < currentNode.getValue()) {
                lastLeftTurn = currentNode;
                currentNode = currentNode.getLeft();
            } else if(node.getValue() > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else { //matched
                if(currentNode.getRight() != null) {
                    return getMinItem(currentNode.getRight());
                } else {
                    return lastLeftTurn;
                }
            }
        }
        return null; // no successor
    }

    public BinarySearchTreeNode getInOrderPredecessor(BinarySearchTreeNode node) {
        BinarySearchTreeNode currentNode = root;
        BinarySearchTreeNode lastRightTurn = null;
        while(currentNode != null) {
            if(node.getValue() < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if(node.getValue() > currentNode.getValue()) {
                lastRightTurn = currentNode;
                currentNode = currentNode.getRight();
            } else {
                if(currentNode.getLeft() != null) {
                    return getMaxItem(currentNode.getLeft());
                } else {
                    return lastRightTurn;
                }
            }
        }
        return null;
    }

    public boolean deleteItem(BinarySearchTreeNode deleteNode) {
        if(deleteNode.getValue() == root.getValue()) {
            root = (root.getRight() == null ? root.getLeft() : root.getRight());
            return true;
        }
        return deleteItem(deleteNode, root, null);
    }

    private boolean deleteItem(BinarySearchTreeNode deleteNode, BinarySearchTreeNode currentNode, BinarySearchTreeNode lastParent) {
        if(currentNode == null) {
            return false;
        } else if(deleteNode.getValue() < currentNode.getValue()) {
            return deleteItem(deleteNode, currentNode.getLeft(), currentNode);
        } else if(deleteNode.getValue() > currentNode.getValue()) {
            return deleteItem(deleteNode, currentNode.getRight(), currentNode);
        } else { // matched
            if(currentNode.isLeaf()) { // leaf
                if (currentNode.getValue() < lastParent.getValue()) {
                    lastParent.setLeft(null);
                } else {
                    lastParent.setRight(null);
                }
                return true;
            } else if(currentNode.getLeft() != null && currentNode.getRight() != null) { // full node
                currentNode.setValue(getMinItem(currentNode.getRight()).getValue());
                return deleteItem(currentNode, currentNode.getRight(), currentNode);
            } else {
                if (currentNode.getValue() < lastParent.getValue()) {
                    lastParent.setLeft(currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft());
                } else {
                    lastParent.setRight(currentNode.getLeft() == null ? currentNode.getRight() : currentNode.getLeft());
                }
                return true;
            }
        }

//        while(currentNode != null) {
//            if(deleteNode.getValue() < currentNode.getValue()) {
//                currentNode = currentNode.getLeft();
//            } else if(deleteNode.getValue() > currentNode.getValue()) {
//                currentNode = currentNode.getRight();
//            } else { //matched
//                if(currentNode.getLeft() != null) {
//                    return getMaxItem(currentNode.getLeft());
//                } else {
//                    return lastRightTurn;
//                }
//            }
//        }
    }
}
