package com.dodo.tutorials.datastructure.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<T extends Comparable> {

    private Node root;

    /**
     * @param data
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * @param root
     * @param data
     * @return
     */
    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (root.getData() == 0) {
            return root;
        } else if (data > root.getData()) {
            // go to right
            root.setRight(insert(root.getRight(), data));
        } else {
            root.setLeft(insert(root.getLeft(), data));
        }
        return root;
    }

    /**
     *
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * @param root
     */
    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        print(root);
        inOrder(root.getRight());
    }

    /**
     *
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * @param root
     */
    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        print(root);
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    /**
     *
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * @param root
     */
    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        print(root);
    }

    /**
     * @param root
     */
    private void print(Node root) {
        System.out.print(root.getData() + " ");
    }

    public void breadthFirstTraversal() {
        breadthFirstTraversal(root);
    }

    /**
     * Visit all nodes at same level N before moving to the next level N+1
     *
     * @param root
     */
    private void breadthFirstTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            print(node);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Read multiple time, understand much better
     *
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        boolean isRootDataSmallerThanMin = root.getData().compareTo(minValue) < 0;
        boolean isRootDataLargerThanMax = root.getData().compareTo(maxValue) > 0;

        if (isRootDataSmallerThanMin || isRootDataLargerThanMax) {
            return false;
        }

        boolean isLeftBst = isBST(root.getLeft(), minValue, (Integer) root.getData());
        boolean isRightBst = isBST(root.getRight(), (Integer) root.getData(), maxValue);

        return isLeftBst && isLeftBst;
    }

    public void printNodesWithinRange() {
        printNodesWithinRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void printNodesWithinRange(Node root, int low, int high) {
        if (root == null) {
            return;
        }
        if (low <= (Integer) root.getData()) {
            printNodesWithinRange(root.getLeft(), low, (Integer) root.getData());
        }

        if (low <= (Integer) root.getData() && high >= (Integer) root.getData()) {
            System.out.println(root.getData());
        }

        if (high > (Integer) root.getData()) {
            printNodesWithinRange(root.getRight(), (Integer) root.getData(), high);
        }
    }

    /**
     * understand it
     * @param numNodes
     * @return
     */
    private int countTrees(int numNodes){
        // when the number of nodes is 1, there is just one possible tree
        // This is the base case
        if(numNodes <= 1){
            return 1;
        }

        int sum = 0;
        for (int i = 0; i <numNodes ; i++) {
            int countLeftTrees = countTrees(i-1);
            int countRightTrees = countTrees(numNodes - i);
            sum = sum + (countLeftTrees * countRightTrees);
        }
        return sum;
    }

    public int findMaxHeight(){
        return findMaxHeight(root);
    }

    /**
     * Find the height of a tree
     * Each node has a height of 1
     * Add 1 + Max of left and height subTree at each node
     * Max of left & right is important
     * @param node
     * @return
     */
    private int findMaxHeight(Node node){
        if(node == null){
            return 0;
        }

        int lefHeight = findMaxHeight(node.getLeft());
        int rightHeight = findMaxHeight(node.getRight());

        return 1 + Math.max(lefHeight, rightHeight);

    }



    /**
     * Look for a nod with data in the BST
     *
     * @param data
     * @return
     */
    public Node lookup(int data) {
        return lookup(root, data);
    }

    /**
     * @param root
     * @param data
     * @return
     */
    private Node lookup(Node root, int data) {

        if (root == null) {
            return null;
        }
        // we found the matching node
        if (root.getData().compareTo(data) == 0) {
            return root;
        }
        if (data > root.getData()) {
            // means it is on right side
            return lookup(root.getRight(), data);
        } else {
            return lookup(root.getLeft(), data);
        }
    }

    public int maxHeight(){
        return maxHeight(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int maxHeight(Node root, int min, int max){
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftHeight = maxHeight(root.getLeft(), min, root.getData());
        int rightHeight = maxHeight(root.getRight(), root.getData(), max);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public void mirror(){
        mirror(root);
    }

    public void mirror(Node root){
        if( root == null){
            return;
        }

        mirror(root.getLeft());
        mirror(root.getRight());
        Node tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

    }

}
