package main;

/**
 *
 * Any to Any
 *
 * i.e.
 *
 *     1
 *    / \
 *   3  4
 *
 *  return 3 + 1 + 4 = 8
 *
 */
public class BinaryTreeMaximumPathSum {

    /**
     * An inner class that contains : maxPath from any to any, maxPath from root to any
     *
     * The longest path can be
     * - path that goes through root,
     * - path that goes from left child tree, to root node
     *          or goes from right child tree, to root node
     */
    public class ReturnType {
        // any to any path max length
        int any2anyMaxPath;
        // root to any path max length
        int root2anyMaxPath;
        ReturnType (int any2anyMaxPath, int root2anyMaxPath) {
            this.any2anyMaxPath = any2anyMaxPath;
            this.root2anyMaxPath = root2anyMaxPath;
        }

    }

    public int maxPathSum(TreeNode root) {
        ReturnType result = helperDFS(root);
        return result.any2anyMaxPath;
    }

    private ReturnType helperDFS(TreeNode root) {
        // root node in null - both maxPath (any2any, root2any) have no solution, put MIN_VALUE
        if (root == null) {
            return new ReturnType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        // Divide
        ReturnType left = helperDFS(root.left);
        ReturnType right = helperDFS(root.right);

        // Conquer
        int root2anyPath = root.val + Math.max(0, Math.max(left.root2anyMaxPath, right.root2anyMaxPath));

        // any 2 any longest path may doesn't cross root
        int any2anyPathNoCrossRt = Math.max(left.any2anyMaxPath, right.any2anyMaxPath);
        // any 2 any longest path may cross root
        int any2anyPathCrossRt = Math.max(0, left.root2anyMaxPath) + Math.max(0, right.root2anyMaxPath) + root.val;
        // compare these two
        int any2anyPath = Math.max(any2anyPathCrossRt, any2anyPathNoCrossRt);
        return new ReturnType(any2anyPath, root2anyPath);
    }
}
