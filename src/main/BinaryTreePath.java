package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysun on 4/17/16.
 */

public class BinaryTreePath {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    public List<String> findPath(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        helper(root, String.valueOf(root.val), res);
        return res;
    }

    private void helper(TreeNode node, String path, List<String> res) {
        if(node == null) {
            return;
        }
        // when this node is the end , adding the obtained path
        if(node.left==null && node.right==null) {
            res.add(path + "->" + node.val);
            return;
        }
        if(node.left==null && node.right!=null) {
            helper(node.right, path + "->" + node.val, res);
        }
        if(node.right!=null && node.right==null) {
            helper(node.left, path + "->" + node.val, res);
        }
    }
}
