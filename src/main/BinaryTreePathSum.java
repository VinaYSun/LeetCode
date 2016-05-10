package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 注意
 * 1. 在主function，初始path要加入root.val
 * 2. 叶节点，result加入path时需要 new ArrayList<Integer>(path), 否则，结果会只含有list的头
 */
public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        int sum = root.val;
        helper(root, path, sum, target, result);
        return result;
    }

    private void helper(TreeNode root, ArrayList<Integer> path, int sum, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }
}
