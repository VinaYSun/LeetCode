package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ysun on 5/5/16.
 */
public class BinaryTreeDepth {

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode dummy = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.offer(root);
        q.offer(dummy);

        int depth = -1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            // every occurrence of dummy node indicate a layer
            if (curr == dummy) {
                depth++;
                // using dummy node to differentiate layers, if the next layer is not null
                // adding dummy node at the end of queue
                if (!q.isEmpty()) {
                    q.offer(dummy);
                }
            }

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return depth;
    }
}
