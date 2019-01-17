package com.company;

// this class is the tree nodes class
// this implementation does not accept duplicates of values, it will not insert a duplicate value in the tree
// the code here is an implementation of the binary tree, this means that each node can have 0, 1, or 2 children nodes only

public class TreeNode {

    private int data;           // the variable that holds the data of the pointed at node itself
    private TreeNode right;     // this is the right child node of the pointed at node
    private TreeNode left;      // this is the left child node of the pointed at node

    public TreeNode(int data) {
        this.data = data;
    }       // a constructor that puts the value in a new leaf node

    public void insert(int value) {                       // this function is about inserting a value into the tree

        if (value == data)                                // if the value that is inserted is already found to be in the tree
            return;                                       // do nothing, that's why this implementation does not accept duplicates of values

        if (value < data) {                               // if the value is < than the data (root's value)
            if (left == null)                             // if there is no left child
                left = new TreeNode(value);               // create a new left child, and input the value in the new left child node
            else                                          // else, if there is a left child node
                left.insert(value);                       // call the insert() function recursively to insert the value in new left node
        } else {                                          // else, if the value > data
            if (right == null)                            // if there is no right child
                right = new TreeNode(value);              // create a new right child, and input the value in the new right child node
            else                                          // else, if there is a right child node
                right.insert(value);                      // call the insert() function recursively to insert the value in a new right node
        }
    }

    public TreeNode get(int value) {                    // this function returns the value if it is found in the tree   (this function is like the insert but with a return)
        if (value == data) {                            // if the value == data (root's value)
            return this;                                // return the root node
        }

        if (value < data) {                             // if the value < data
            if (left != null) {                         // if there is a left child
                return left.get(value);                 // call this function recursively to traverse more in this subtree (of the left child)
            }
        } else {                                        // else, if the value > data
            if (right != null) {                        // if there is a right child
                return right.get(value);                // call this function recursively to traverse more in this subtree (of the right child)
            }
        }
        return null;                                    // if the value is not found, return null
    }


    public int min() {              // this function returns the minimum value in the tree
        if (left == null)           // if the left node is not present
            return data;            // return data of the left node
        else                        // else, if there is a left node
            return left.min();      // call this function recursively to traverse more in the left child node, as the minimum value is the bottom left node, so it will go down the left
    }

    public int max() {              // this function returns the maximum value in the tree
        if (right == null)          // if the right node is not present
            return data;            // return data of the right node
        else                        // else, if there is a right node
            return right.max();     // call this function recursively to traverse more in the right child node, as the maximum value is the bottom right node, so it will go down the right
    }

    public void traverseInOrder() {             // this function is used to print out the tree in the in-order style    (printing order: left child -> parent -> right child)
        if (left != null)                       // if there is a left child node
            left.traverseInOrder();             // recursively call this function to get to the bottom left item, when it reaches it, it will print it out

        System.out.print(data + ", ");          // print out the data of the root node, or in the case of recursion it will make the children nodes parents and print them out

        if (right != null)                      // if there is a right child node
            right.traverseInOrder();            // recursively call this function to get to the bottom right item, when it reaches it, it will print it out
    }

    public void traversePreOrder() {             // this function is used to print out the tree in the pre-order style      (printing order: parent -> left child -> right child)

        System.out.print(data + ", ");          // print out the data of the root node, or in the case of recursion it will make the children nodes parents and print them out
        if (left != null)                       // if there is a left child node
            left.traverseInOrder();             // recursively call this function to get to the bottom left item, when it reaches it, it will print it out
        if (right != null)                      // if there is a right child node
            right.traverseInOrder();            // recursively call this function to get to the bottom right item, when it reaches it, it will print it out
    }

    public void traversePostOrder() {             // this function is used to print out the tree in the post-order style      (printing order: left child -> right child -> parent)

        if (left != null)                       // if there is a left child node
            left.traverseInOrder();             // recursively call this function to get to the bottom left item, when it reaches it, it will print it out
        if (right != null)                      // if there is a right child node
            right.traverseInOrder();            // recursively call this function to get to the bottom right item, when it reaches it, it will print it out
        System.out.print(data + ", ");          // print out the data of the root node, or in the case of recursion it will make the children nodes parents and print them out
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public String toString() {              // you need to override this function to print out any node (object) of the tree
        return "Data = " + data;
    }
}