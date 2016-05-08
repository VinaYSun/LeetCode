package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ysun on 5/5/16.
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode (int val) {
        this.val = val;
    }
}
public class BinaryTreeDepth {

    public int getDepthRec(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    /**
     ********  Adding dummy node between each layer *******
     *
     * iterate through queue until is empty
     *   popping out first node in queue
     *
     * when it is "dummy node", depth is adding one;
     *      also when queue is not empty, adding a dummy node at the end of next layer
     * if left child exists, adding;
     * if right child exists, adding.
     *
     */
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode dummy = new TreeNode(0);
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        // first layer
        q.offer(root);
        q.offer(dummy);

        int depth = -1;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            // every occurrence of dummy node indicate
            // 1. one layer is traversed completely, counting plus one
            // 2. meanwhile, the next layer has been pushed into queue (if there has next layer)
            //    adding dummy node to indicate layer.
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
