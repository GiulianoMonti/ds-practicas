package giulian.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree() {
        root = null;
    }

    // Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) { //
        if (currentNode == null) {          //base condition
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            // System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) { // we insert it in the left SubArray
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value); //insert in the right SubArray
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }


    // PreOrder Traversal

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");  //root , left , right
        preOrder(node.left);
        preOrder(node.right);
    }

    // Inorder Traversal
    public void inOrder(BinaryNode node) {    // left , root , right
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);


    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {   //left , right , root
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order

    void levelOrder() {   // level 1 , level 2 . level 3 . level 4
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root); // add root node to the queue
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null ) {
            System.out.println("Value: "+ value+ " not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: "+ value+ " found in BST");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value); // searching the node we want to delete
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value); // searching the node we want to delete
        } else {
            if (root.left != null && root.right != null) { // if current node has two children
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right); //set root to minimum node
                root.value = minNodeForRight.value; //
                root.right = deleteNode(root.right, minNodeForRight.value); //delete minimum node from the subArray
            } else if (root.left != null) {
                root = root.left;   //set left to root
            } else if (root.right != null) {
                root = root.right;  //set right to root
            } else {
                root = null;
            }
        }

        return root;

    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }






}
