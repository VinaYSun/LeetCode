package main;

/**
 * Created by ysun on 5/8/16.
 */
public class ValidateBinarySearchTree {
    private class ResultType {
        int minVal;
        int maxVal;
        boolean isBST;
        ResultType(boolean isBST, int minVal, int maxVal) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.isBST = isBST;
        }
    }

    public boolean validateBinarySearchTree (TreeNode root){
        ResultType r = helper(root);
        return r.isBST;
    }

    public ResultType helper(TreeNode node) {
        if (node == null) {
            // 注意是minVal赋最大值
            // maxVal赋最小值，
            // 这样才能保证，这两个值被更大或是更小的值取代
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);

        if (!left.isBST || !left.isBST) {
            return new ResultType(false, 0, 0);
        }

        // 注意是
        // left最大要 < root.val
        // right最小 > root.val
        if (node.left != null && left.maxVal >= node.val ||
                node.right !=null && right.minVal <= node.val) {
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true, Math.min(node.val, left.minVal), Math.max(node.val, right.maxVal));
    }

}
