package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class BinaryTreeNodeNumber {

    // Non recursive
    public int getNumberNonRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            count++;
        }
        return count;
    }

    // Recursive
    public int getNumberRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getNumberRec(root.right) + getNumberRec(root.left) + 1;
    }

}

