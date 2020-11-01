package com.dodo.tutorials.datastructure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst;

    @BeforeEach public void setUp() {

    }

    @Test public void testInsertAndInOrder() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 30 40 45 50 60
        bst.inOrder();
    }

    @Test public void testPreOrder() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 50 40 30 45 60
        bst.preOrder();
    }

    @Test
    public void testPostPreOrder() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 30 45 40 60 50
        bst.postOrder();
    }

    @Test
    public void testPreadthFirstOrder() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 50 40 60 30 45
        bst.breadthFirstTraversal();
    }

    @Test
    public void testIsBst() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        System.out.println(bst.isBST());
    }

    @Test void testLookup() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        Node node = bst.lookup(30);
        Assertions.assertNotNull(node);

        node = bst.lookup(130);
        Assertions.assertNull(node);
    }

    @Test void testIsBST() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(60);
//        bst.add(45);
//        bst.add(60);
        /**
         * to check whether a binary tree is a Binary Search Tree(BST) or not, we do followings:
         * recursively check the leaf level left node if it is a BST
         * recursively check right leaf node, it if is a BST
         * for BST:
         * 1. The left child value should be less than the node value
         * 2. The right child value should be greater than the node value
         * 3. if both left and right child are BST, then the root node is a BST
         *
         *
         * In this example, the code start with root 50,
         * it check if node is null, then return true but the node is not null,
         * Start with Integer.minValue as minValue and Integer.maxValue as the maxValue
         * for each root node, make sure that the root node value should not be less than the min value
         * and node value should not be more than max value
         *
         * check leftSubtree and check rightSubtree
         * If both are BST, return true
         * check left and right
         */
        boolean isBst = bst.isBST();
        Assertions.assertTrue(isBst);
    }

    @Test void testPrintNodesInRange() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(60);
        bst.insert(30);
        bst.insert(45);
        // it is nothing but the InOrder traversal
        bst.printNodesWithinRange();
    }

    @Test void testFindHeight() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(40);
        bst.insert(60); // here height is 2 for root 50. 1 for self and max of left(40) & right(50)
        bst.insert(30); // here height is 3 for root 50. 1 for self and max of left which is 2
        bst.insert(40); // here height is 3 for root 50. 1 for self and max of left which is 2
        bst.insert(20); // here height is 4 for root 50. 1 for self and max of left & right which is 2 + 1 & max of left(20)
        int h = bst.findMaxHeight();
        System.out.println(h);
    }

    @Test void testMirror() {
        bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(60);
        bst.insert(30);
        bst.insert(60);
        bst.inOrder();
        bst.mirror();
        bst.inOrder();

    }
}
