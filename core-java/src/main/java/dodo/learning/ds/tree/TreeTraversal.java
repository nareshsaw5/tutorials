package dodo.learning.ds.tree;

import java.util.Queue;

public class TreeTraversal {
    
    /**
     * Breadth-First traversal of a binary tree
     * in this traversal, the program traverse left and right first at the same level 
     * before moving to the next level
     * @param root
     */
    /**
    public void breadthFirstTraversion(Node root) {
        
        Queue<Node> queue = new Queue(Node.class);
        queue.engue(root);
        while(!queue.isEmpty()) {
            Node node = queue.deque();
            print(node);
            if(node.getLeftChild() != null) {
                queue.enque(node.getLeftChild());
            }
            if(node.getRightChild() != null) {
                queue.enque(node.getRightChild());
            }
        }
    }
    */
    
    /**
     * In PreOrder traversal, first node is traversed, then left child and then right child.
     */
    /**
    public void preOrderTraversal(Node<Character> node) {
        // the base case in the recursion
        if(node == null) {
            return ;
        }
        print(node);
        preOrderTraversal(node.getLeftChild());
        preOrderTraversal(node.getRightChild());
    
    }
    */
    
    /**
     * In InOrder traversal, first node is traversed, then left child and then right child.
     */
    /**
    public void InOrderTraversal(Node<Character> node) {
        // the base case in the recursion
        if(node == null) {
            return ;
        }
       
        preOrderTraversal(node.getLeftChild());
        print(node);
        preOrderTraversal(node.getRightChild());
    
    }
    */
    
    /**
     * In PostOrder traversal, first child node is traversed, then right child and then the node is traversed.
     */
    /**
    public void InOrderTraversal(Node<Character> node) {
        // the base case in the recursion
        if(node == null) {
            return ;
        }
       
        preOrderTraversal(node.getLeftChild());
        print(node);
        preOrderTraversal(node.getRightChild());
    
    }
    */
    
    
    /**
     * Insert in the Binary Search Tree(BST)
     * if node value is less than head value, go to left with recursion
     * if node value is greater than head value, then go to the right of head
     * 
     */
    public Node<Integer> insert(Node<Integer> head, Node<Integer> node) {
        if(head == null) {
            return node;
        }
        if(node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(),node));
        }else {
            head.setRightChild(insert(head.getRightChild(), node));
        }
        return head;
    }
    
    
    public Node<Integer> lookup(Node<Integer> head, int data) {
        
        if(head == null) {
            return null;
        }
        
        if(head.getData() == data) {
            return head;
        }
        if(data <= head.getData()) {
            return lookup(head.getLeftChild(), data);
        }else {
            return lookup(head.getRightChild(), data);
        }
    }
    
    
    /**
     * 
     * @param head
     * @return
     */
    public Integer findMinimumValue(Node<Integer> head){
        if(head == null) {
            return Integer.MIN_VALUE;
        }
        if(head.getLeftChild() == null ) {
            return head.getData();
        }
        return findMinimumValue(head.getLeftChild());
    }
    
    
    /**
     * find the max depth
     * @param head
     * @return
     */
    public int maxDepth(Node<Integer> head) {
        // base case in the recursion
        if(head == null ) {
            return 0;
        }
        // add 1 in each traversal
        int leftDepth = 1 + maxDepth(head.getLeftChild());
        int rightDepeth = 1 + maxDepth(head.getRightChild());
        
        return Math.max(leftDepth, rightDepeth);
    }
    
    // Mirror a binary search tree (BST)
    public void mirror(Node<Integer> head) {
        if(head == null) {
            return;
        }
        mirror(head.getLeftChild());
        mirror(head.getRightChild());
        
        Node<Integer> tmp = head.getLeftChild();
        head.setLeftChild(head.getRightChild());
        head.setRightChild(tmp);
    }
    
    /**
     * count tree, how could you create structurally unique binary tree
     */
    public int countTrees(int numOfNodes) {
        // base case
        if(numOfNodes <= 1 ) {
            return 1;
        }
        int sum = 0;
        for(int i = 0; i< numOfNodes; i++ ) {
            int countLeftTrees = countTrees(i-1); //
            int countRightTrees = countTrees(numOfNodes-i);
            sum = sum + (countLeftTrees * countRightTrees);
        }
        return sum;
    }
    // print all nodes within a range in a BST
    public void printRange(Node<Integer> root, int low, int high) {
        // base case check
        if(root == null) {
            return;
        }
        
        if(low < root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }

        // check if the node value is within the range of low and high
        if(low < root.getData() && high > root.getData()) {
            System.out.println(root.getData());
        }
        
        if(high > root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }
    
    // check if a binary tree is a binary search tree
    public boolean isBinaryTree(Node<Integer> root, int low, int high) {
        // base check in recursion
        if( root == null) {
            return true;
        }
        
        if(root.getData() <= low && high > root.getData()) {
            return false;
        }
        
        return isBinaryTree(root.getLeftChild(), low, root.getData()) &&
                isBinaryTree(root.getRightChild(), root.getData(), high);
        
    }

}
