package com.dodo.tutorials.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test public void testInsertAndInOrder() {
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 30 40 45 50 60
        bst.inOrder();
    }

    @Test public void testPreOrder() {
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 50 40 30 45 60
        bst.preOrder();
    }

    @Test public void postPreOrder() {
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 30 45 40 60 50
        bst.postOrder();
    }

    @Test public void breadthFirstOrder() {
        bst.insert(50);
        bst.insert(40);
        bst.insert(30);
        bst.insert(45);
        bst.insert(60);
        // 50 40 60 30 45
        bst.breadthFirstTraversal();
    }
}
