package Java;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Inorder Traversal
 * left child -> parent -> right child
 *
 * -- only applicable to binary tree
 */

public class BinaryTreeInOrderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        TreeNode current = root;
        while( current != null || !stack.isEmpty()) {
            // move cur pointer to the most left
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // move pointer from left to its parent node
            current = stack.pop();
            result.add(current.val);

            // move pointer to right child
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {

        /**
         *      5
         *     / \
         *    1  2
         *   / \
         *  4  6
         */
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
        System.out.println("Tree nodes are" + bs.inorderTraversal(root));

    }}
