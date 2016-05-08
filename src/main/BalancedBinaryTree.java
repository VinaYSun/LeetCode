package main;

/**
 * Created by ysun on 5/6/16.
 */
public class BalancedBinaryTree {

    /**
     * Divide and Conquer
     *
     * 两种情况，非平衡树，平衡树
     *
     * helper function 返回值 -1-非衡；树深-平衡
     *
     */
    public boolean isBalanced(TreeNode root) {
        if ( maxDepth(root) != -1 ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Divide and Conquer
     *
     * node是空，深度为0的平衡树
     * 求左树深；求右树深
     * 左/右树树深为 -1；左右树深相差大于1时，返回非平衡-1
     * Otherwise, 返回左右树深最大值 + 1 返回
     */
    private int maxDepth(TreeNode node){
        if (node == null) {
            return 0; // 空树，树深为0
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        // depth -1 表示非平衡树
        // 左子树或右子树或为非平衡树，或当左子树、右子树均为平衡树但是两个子树树深相差大于1时
        // 返回树深 -1 表示非平衡树
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        // 返回子树最深的深度 + 根节点（1）
        return Math.max(left, right) + 1;

    }
}
