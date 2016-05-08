package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * BFS 1 queue
     *
     *
     * iterate through queue until is empty
     *   popping out first node in queue
     *
     * when it is "dummy node", depth is adding one;
     *      also when queue is not empty, adding a dummy node at the end of next layer
     * if left child exists, adding;
     * if right child exists, adding.
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            // pop and save value of first Nth (The current level) child in queue
            // meanwhile, put all next level children into queue
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }


    /**
     * BFS 2 queue
     */
    public ArrayList<ArrayList<Integer>> levelOrderTwo(TreeNode root) {
        ArrayList result = new ArrayList();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> q1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> q2 = new ArrayList<TreeNode>();

        q1.add(root);

        while (!q1.isEmpty()) {
            ArrayList<Integer> lvl = new ArrayList<Integer>();
            q2.clear();
            for (int i = 0; i < q1.size(); i++) {
                lvl.add(q1.get(i).val);
                TreeNode n = q1.get(i);
                if (n.left != null) {
                    q2.add(n.left);
                }
                if (n.right != null) {
                    q2.add(n.right);
                }

            }
            // swap q1 and q2
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            temp = q1;
            q1 = q2;
            q2 = temp;

            result.add(lvl);
        }
        return result;
    }

    /**
     * DFS
     * Didn't fully understand this part
     */
//    public ArrayList<ArrayList<Integer>> levelOrderDFS(TreeNode root) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        if (root == null) {
//            return result;
//        }
//
//        int maxLevel = 0;
//
//        while (true) {
//            ArrayList<Integer> lvl = new ArrayList<Integer>();
//            dfs(root, lvl, 0, maxLevel);
//            if (lvl.size() == 0) {
//                break;
//            }
//            result.add(lvl);
//            maxLevel++;
//        }
//        return result;
//    }
//
//    private void dfs(TreeNode root, ArrayList<Integer> level, int currLevel, int maxLevel) {
//        if (root == null || currLevel > maxLevel) {
//            return;
//        }
//
//        if (currLevel == maxLevel) {
//            level.add(root.val);
//            return;
//        }
//
//        dfs(root.left, level, currLevel + 1, maxLevel);
//        dfs(root.right, level, currLevel + 1, maxLevel);
//
//    }
}
