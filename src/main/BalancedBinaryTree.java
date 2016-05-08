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

    /**
     * 输入根节点，输出
     * @param node 根节点
     * @return 树深 --  -1 ：非平衡树； 0 ： 空树； 其它：平衡树的树深
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
