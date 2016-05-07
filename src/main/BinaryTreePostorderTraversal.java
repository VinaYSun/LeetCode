package main;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ysun on 5/4/16.
 */
public class BinaryTreePostorderTraversal {

    // left -> right -> parent === reverse( parent -> right-> left )
    // solution 1: recursive.
    public ArrayList<Integer> traversalRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        result.addAll(traversalRec(root.left));
        result.addAll(traversalRec(root.right));
        result.add(root.val);
        return result;
    }

    // solution 2: no recursive.
    public ArrayList<Integer> traversalNoRec(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();

        if (root == null) {
            return result;
        }

        stack.push(root);
        // post order but in parent -> right -> left order
        // in stack pushing, push the left first, then the right
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            // each pop, push each node into the 2nd stack
            output.push(curr);

            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        // pop 2nd stack
        while (!output.isEmpty()) {
            result.add(output.pop().val);
        }
        return result;
    }
}
