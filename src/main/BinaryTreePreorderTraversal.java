package main;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * Contains DFS in Binary Tree in:
 *
 * - Pre-order
 *
 * Parent -> left child -> right child
 *
 * using a stack - > push right, left.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BinaryTreePreorderTraversal {

    // Solution 1 - non recursive
    public ArrayList<Integer> traversalNonRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return result;
        }
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    // solution 2 : Traverse
    public ArrayList<Integer> traversalRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode node, ArrayList<Integer> result){
        if (node == null) {
            return;
        }
        // 前序，所以先加入根节点，再加入左子树，右子树
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }

    // solution 3: divide & conquer
    public ArrayList<Integer> traversalDC(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (node == null) {
            return result;
        }

        // 分解为规模小的同类问题，求解
        ArrayList<Integer> left = traversalDC(node.left);
        ArrayList<Integer> right = traversalDC(node.right);

        // 合并，将小问题的解逐层合并构成原问题的解
        result.add(node.val);
        result.addAll(left);
        result.addAll(right);

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);

        root.left = a;
        root.right = b;

        a.left = c;

        BinaryTreePreorderTraversal bs = new BinaryTreePreorderTraversal();

        System.out.println("Tree nodes are" + bs.traversalNonRec(root));
        System.out.println("Tree nodes are" + bs.traversalRec(root));
        System.out.println("Tree nodes are" + bs.traversalDC(root));

    }
}

