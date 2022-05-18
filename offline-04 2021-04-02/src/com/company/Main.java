package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

//        BinarySearchTreeNode node1 = new BinarySearchTreeNode(3);
//        BinarySearchTreeNode node2 = new BinarySearchTreeNode(2);
//        BinarySearchTreeNode node3 = new BinarySearchTreeNode(5);
//        BinarySearchTreeNode node4 = new BinarySearchTreeNode(11);
//        BinarySearchTreeNode node5 = new BinarySearchTreeNode(1819);
//        BinarySearchTreeNode node6 = new BinarySearchTreeNode(12477);
//        BinarySearchTreeNode node7 = new BinarySearchTreeNode(335);
//        BinarySearchTreeNode node8 = new BinarySearchTreeNode(3698);
//        BinarySearchTreeNode node9 = new BinarySearchTreeNode(8);
//        BinarySearchTreeNode node10 = new BinarySearchTreeNode(2289);
//        BinarySearchTreeNode node11 = new BinarySearchTreeNode(87);
//        BinarySearchTreeNode node12 = new BinarySearchTreeNode(33);
//        BinarySearchTreeNode node13 = new BinarySearchTreeNode(69);
//        BinarySearchTreeNode node14 = new BinarySearchTreeNode(12);
//        BinarySearchTreeNode node15 = new BinarySearchTreeNode(39);
//
//        bst.insertItem(node1);
//        bst.insertItem(node2);
//        bst.insertItem(node3);
//        bst.insertItem(node4);
//        bst.insertItem(node5);
//        bst.insertItem(node6);
//        bst.insertItem(node7);
//        bst.insertItem(node8);
//        bst.insertItem(node9);
//        bst.insertItem(node10);
//        bst.insertItem(node11);
//        bst.insertItem(node12);
//        bst.insertItem(node13);
//        bst.insertItem(node14);
//        bst.insertItem(node15);


//        bst.searchItem(node5);
//        bst.searchItem(node15);
//        bst.searchItem(new BinarySearchTreeNode(12));
//        bst.searchItem(new BinarySearchTreeNode(5555));

//        bst.printInOrder();
//        System.out.println();
//        bst.printPreOrder();
//        System.out.println();
//        bst.printPostOrder();
//        System.out.println();

//        System.out.println(bst.getHeight());

//        System.out.println(bst.getSize());

//        System.out.println(bst.getMaxItem().getValue());
//        System.out.println(bst.getMinItem().getValue());

//        System.out.println(bst.getInOrderSuccessor(node6) == null ? "No Successor" : bst.getInOrderSuccessor(node6).getValue());
//        System.out.println(bst.getInOrderPredecessor(node15) == null ? "No Predecessor" : bst.getInOrderPredecessor(node15).getValue());

//        System.out.println(bst.getItemDepth(node14));

//        bst.printInOrder();
//        System.out.println();
//
//        bst.deleteItem(node5);
//        bst.printInOrder();
//        System.out.println();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert Item\n" +
                    "2. Search Item\n" +
                    "3. Get In Order Successor\n" +
                    "4. Get In Order Predecessor\n" +
                    "5. Delete Item\n" +
                    "6. Get Item Depth\n" +
                    "7. Get Max Item\n" +
                    "8. Get Min Item\n" +
                    "9. Get Height\n" +
                    "10. Print In Order\n" +
                    "11. Print Pre Order\n" +
                    "12. Print Post Order\n" +
                    "13. Get Size");

            int menuInput = -1;
            try {
                menuInput = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
//                e.printStackTrace();
                break;
            }

            if (menuInput == 1) {
                System.out.println("Enter some integers in different lines");
                String currentInput = null;
                while(true) {
                    currentInput = sc.nextLine();
                    if(currentInput.isBlank()) break;
                    bst.insertItem(new BinarySearchTreeNode(Integer.parseInt(currentInput)));
                }
                System.out.println("Insertion Done");
            } else if (menuInput == 2) {
                System.out.println("Insert the integer you would like to search");
                int currentInput = Integer.parseInt(sc.nextLine());
                bst.searchItem(new BinarySearchTreeNode(currentInput));
            } else if (menuInput == 3) {
                System.out.println("Insert the integer you would like to get the successor of");
                int currentInput = Integer.parseInt(sc.nextLine());
                System.out.println(bst.getInOrderSuccessor(new BinarySearchTreeNode(currentInput)).getValue());
            } else if (menuInput == 4) {
                System.out.println("Insert the integer you would like to get the predecessor of");
                int currentInput = Integer.parseInt(sc.nextLine());
                System.out.println(bst.getInOrderPredecessor(new BinarySearchTreeNode(currentInput)).getValue());
            } else if (menuInput == 5) {
                System.out.println("Enter the number to be deleted");
                int currentInput = Integer.parseInt(sc.nextLine());
                System.out.println(bst.deleteItem(new BinarySearchTreeNode(currentInput)));
            } else if (menuInput == 6) {
                System.out.println("Enter the number to calculate depth");
                int currentInput = Integer.parseInt(sc.nextLine());
                System.out.println(bst.getItemDepth(new BinarySearchTreeNode(currentInput)));
            } else if (menuInput == 7) {
                System.out.println(bst.getMaxItem().getValue());
            } else if (menuInput == 8) {
                System.out.println(bst.getMinItem().getValue());
            } else if (menuInput == 9) {
                System.out.println(bst.getHeight());
            } else if (menuInput == 10) {
                bst.printInOrder();
                System.out.println();
            } else if (menuInput == 11) {
                bst.printPreOrder();
                System.out.println();
            } else if (menuInput == 12) {
                bst.printPostOrder();
                System.out.println();
            } else if (menuInput == 13) {
                System.out.println(bst.getSize());
            } else {
                break;
            }
        }
    }
}
