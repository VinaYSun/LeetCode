package Java;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意
 * 1. 记录path时，做int to String装换，String.valueOf(node.val)
 * 2. 遇到空节点返回，叶节点在result里传入的path
 * 3. 向左走向右走的传入path要包含左/右点的val, 例如function(path + "->" + root.left.val)
 */

public class BinaryTreePath {

    public List<String> findPath(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        String path = String.valueOf(root.val);
        helper(root, path, result);
        return result;
    }

    private void helper(TreeNode root, String path, List<String> result) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if(root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if(root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
