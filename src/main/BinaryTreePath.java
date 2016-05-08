package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */

public class BinaryTreePath {

    /**
     * @param root
     * @return all root-to-leaf paths
     */
    public List<String> findPath(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        helper(root, String.valueOf(root.val), res);
        return res;
    }

    /**
     *
     * Black box for processing paths.
     *
     */
    private void helper(TreeNode node, String path, List<String> res) {
        if(node == null) {
            return;
        }
        // when this node is leaf node
        // one path finished, adding to result
        if(node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        // move pointer from current to left child
        // also add left child's value onto path
        if(node.left != null) {
            String p = path + "->" + String.valueOf(node.left.val);
            helper(node.left, p, res);
        }

        // move pointer from current to right child
        // also add right child's value onto path
        if(node.right != null) {
            String p = path + "->" + String.valueOf(node.right.val);
            helper(node.right, p, res);
        }
    }
}
