package main;

/**
 * Created by ysun on 5/6/16.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if ( maxDepth(root) != -1 ) {
            return true;
        } else {
            return false;
        }
    }

    private int maxDepth(TreeNode node){
        if (node == null) {
            return 0; // end value = 0 !
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;

    }
}
