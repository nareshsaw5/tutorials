package com.dodo.tutorials.datastructure.tree;

public class Node<T> {

    private T data;
    private Node left;
    private Node right;

    public Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Node<?> node = (Node<?>) o;

        return data != null ? data.equals(node.data) : node.data == null;
    }

    @Override public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
