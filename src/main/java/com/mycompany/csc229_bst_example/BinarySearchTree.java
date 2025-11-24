package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        if(root == null){ // if the tree is empty return and break execution
            return;
        }
        doInOrder(root.getLeft());
        System.out.println(root.getData());
        doInOrder(root.getRight());
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
    }

    private void doPreOrder(BstNode root){
        if(root == null){ // if the tree is empty return and break execution
            return;
        }
        System.out.println(root.getData()); // get current node
        doInOrder(root.getLeft()); // left sub
        doInOrder(root.getRight()); // right sub
    }

    public void findHeight() {

        System.out.println(doHeight(this.root));
    }

    private Integer doHeight(BstNode root){
        if(root == null){
            return -1; // invalid size
        }

        //System.out.println(root.getData()); // DEBUG: read current node
        int rightCount = doHeight(root.getRight()); // compute right by traversal
        int leftCount = doHeight(root.getLeft()); // compute left by traversal

        if (leftCount > rightCount){
            return leftCount+1;
        } else {
            return rightCount+1;
        }
    }

    

    public void getDepth(int key) {

        if(testNode(this.root, key) == 0){
            System.out.println(searchNode(this.root, key));
        } else {
            System.out.println("Key not found!");
        }
    }

    public int searchNode(BstNode root, int keyValue){ // similar to testNode but increments.
                                                       // used in getDepth
        if (root == null){
            return -1; // invalid size
        }

        int nodeData = root.getData();

        if(nodeData == keyValue){
            return 0; // exists
        }
        if(nodeData < keyValue){
            return searchNode(root.getRight(), keyValue) + 1;
        } else {
            return searchNode(root.getLeft(), keyValue) + 1;
        }
    }

    public int testNode(BstNode root, int keyValue){
        if (root == null){
            return -1; // invalid size
        }

        int nodeData = root.getData();

        if(nodeData == keyValue){
            return 0; // exists
        }
        if(nodeData < keyValue){
            return testNode(root.getRight(), keyValue);
        } else {
            return testNode(root.getLeft(), keyValue);
        }
    }

   public void printBST(){
       System.out.println("\n==== BST Print ===== \n");
       System.out.println(print(" ", this.root));
   }

   public String print(String separator, BstNode root ) {
       if(root == null){
           return "";
       }

       System.out.print(root.getData() + separator); // get current node

       print(" " ,root.getLeft()); // left sub
       print(" " ,root.getRight()); // right sub
       return "";
    }


}
