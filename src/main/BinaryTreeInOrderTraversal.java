package main;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Inorder Traversal
 * left child -> parent -> right child
 *
 * -- only applicable to binary tree
 */

public class BinaryTreeInOrderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            // put top node into the list from stack
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(6);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        BinaryTreeInOrderTraversal bs = new BinaryTreeInOrderTraversal();

        System.out.println("Tree nodes are" + bs.postorderTraversal(root));

    }}
