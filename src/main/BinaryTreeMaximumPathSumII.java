package main;

/**
 * Root to any
 *
 */
public class BinaryTreeMaximumPathSumII {

    /**
     * D & C
     *
     * Trick part
     *
     * The node might have negative value
     * for example {-1, -3, -7}
     *
     * then the maximum would be root only
     * so when root == null, maximum path sum is MIN_VALUE
     * if all path < 0, ignore that path and return 0. Then path will be only adding root value.
     *
     * @param root
     * @return
     */
    public int getSum (TreeNode root) {
        if (root == null){
            return Integer.MIN_VALUE;
//          return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
//        return Math.max(left, right) + root.val;
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
