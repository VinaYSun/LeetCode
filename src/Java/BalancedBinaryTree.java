package Java;

/**
 * Created by ysun on 5/6/16.
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (treeHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
