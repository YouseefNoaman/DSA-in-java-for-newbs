package com.company;

/*
 *
 *       this class is responsible for the tree properties (functions)
 *
 */
public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
        else
            root.insert(value);
    }

    public TreeNode get(int value) {        // this function returns a value
        if (root != null)                   // if the tree is not empty
            return root.get(value);         // return the value

        return null;
    }

    public void delete(int value) {          // this function is used to delete a value from the tree
        root = delete(root, value);         // this is a recursive solution to delete a node from the tree, the parameters are the root of the tree and the value to be deleted
    }

    private TreeNode delete(TreeNode subRoot, int value) {       // this is a recursive solution to delete a value from the tree
        if (subRoot == null)                                    // if the root of the tree or the subtree is null
            return subRoot;                                     // return that node

        if (value < subRoot.getData())                          // if the value < the root of the tree or the subtree
            subRoot.setLeft(delete(subRoot.getLeft(), value));  // call the function recursively and send the left child node (as the left side is smaller) and the value to be deleted
        else if (value > subRoot.getData())                         // if the value > the root of the tree or the subtree
            subRoot.setRight(delete(subRoot.getRight(), value));    // call the function recursively and send the right child node (as the right side is larger) and the value to be deleted
        else {                                                       // else, the value is found
            // if the deleted node has 0 or 1 children
            // the next part works like this, if the deleted node has no children, then it will return null in the next condition, so it will replace the node with null
            // so the node will be deleted anyway, but if it has a right child, it will replace the deleted parent node, same for the left child node, if none is found, it will be null
            if (subRoot.getLeft() == null)                          // if the root tree or the subtree does not have a left child
                return subRoot.getRight();                          // return the right child to replace the node to be deleted
            else if (subRoot.getRight() == null)                    // if the root tree or the subtree does not have a right child
                return subRoot.getLeft();                           // return the left child to replace the node to be deleted

            // the third probability is that the deleted node has 2 children, the next part of the code will handle it
            subRoot.setData(subRoot.getRight().min());            // this is used to replace the deleted node with the smallest value node in the right subtree
            subRoot.setRight(delete(subRoot.getRight(), subRoot.getData()));        // this is used to delete the right node and its value (node's data)

        }
        return subRoot;                                             // return the deleted node
    }

    public int min() {
        if (root == null)                   // if the tree is empty, there is no root node
            return Integer.MIN_VALUE;       // return the minimum value that an integer could hold (-2147483648), as you can't return null because the function returns an int
        else
            return root.min();              // else return the minimum value in the tree
    }

    public int max() {
        if (root == null)                  // if the tree is empty, there is no root node
            return Integer.MAX_VALUE;      // return the maximum value that an integer could hold (2147483648), as you can't return null because the function returns an int
        else
            return root.max();             // else return the maximum value in the tree
    }

    public void traverseInOrder() {        // this function traverses the tree in-order
        if (root != null)                  // if the tree is populated
            root.traverseInOrder();        // traverse the whole tree
    }

    public void traversePreOrder() {        // this function traverses the tree pre-order
        if (root != null)                   // if the tree is populated
            root.traversePreOrder();        // traverse the whole tree
    }

    public void traversePostOrder() {        // this function traverses the tree post-order
        if (root != null)                   // if the tree is populated
            root.traversePostOrder();        // traverse the whole tree
    }

}
