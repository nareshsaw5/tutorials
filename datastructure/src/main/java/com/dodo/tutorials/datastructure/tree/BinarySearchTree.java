package com.dodo.tutorials.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    /**
     * @param data
     */
    public void insert(T data) {
        root = insert(root, data);
    }

    /**
     * @param root
     * @param data
     * @return
     */
    private Node insert(Node root, T data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.compareTo(root.getData()) == 0) {
            return root;
        } else if (data.compareTo(root.getData()) > 0) {
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
        System.out.print(root.getData()+" ");
    }

    public void breadthFirstTraversal(){
        breadthFirstTraversal(root);
    }

    /**
     * Visit all nodes at same level N before moving to the next level N+1
     * @param root
     */
    private void breadthFirstTraversal(Node<T> root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            print(node);
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }



}
