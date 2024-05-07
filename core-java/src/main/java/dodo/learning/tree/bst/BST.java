package dodo.learning.tree.bst;

public class BST {


    private Node root;

    public BST() {
    }

    public BST(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insert(int val){
        // start from the root
        return this.insert(this.root, val);
    }

    // this is recursive call
    public Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            if(this.root == null) this.root = root;
            return root;
        }
        // go to the right
        if(val > root.getValue()){
            root.setRight(insert(root.getRight(), val));
        }else if(val < root.getValue()){
            root.setLeft(insert(root.getLeft(), val));
        }
        return root;
    }

    public void inOrder(){
        System.out.println("===inOrder====");
        this.inOrder(this.root);

    }
    // visit the left node first, then node, then right
    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
    }

    public void preOrder(){
        System.out.println("===preOrder====");
        this.preOrder(this.root);
    }

    public void preOrder(Node node){
        if(node == null) return;
        System.out.println(node.getValue());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    public void postOrder(){
        System.out.println("===postOrder====");
        this.postOrder(this.root);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getValue());
    }

    public void breadthFirstTraversal(){

    }


    public void breadthFirstTraversal(Node node){

    }


    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(45);
        bst.insert(30);
        bst.insert(50);
        bst.insert(25);
        bst.insert(33);
        bst.insert(60);
        bst.insert(47);
        bst.inOrder();
        System.out.println("=======");
        bst.preOrder();
        System.out.println("=======");
        bst.postOrder();
    }
}
