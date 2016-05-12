package main;


import java.util.ArrayList;

/**
 * Created by ysun on 5/8/16.
 */
public class LowestCommonAncestor {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Solution 1, based on the TreeNode has parent pointer
    public TreeNode lowestCommonAncestor(TreeNode node1, TreeNode node2) {
        ArrayList<TreeNode> list1 = getPath2Root(node1);
        ArrayList<TreeNode> list2 = getPath2Root(node2);

        int i, j;
        // two pointers to two paths
        for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
            // stop pointer once they are different
            // move the pointer to its parent
            if (list1.get(i) != list2.get(j)) {
                return list1.get(i).parent;
            }
        }
        return list1.get(i + 1);
    }

    // get a path that trace from current node to the root of this tree
    // * assuming a node has parent pointer.
    private ArrayList<TreeNode> getPath2Root(TreeNode node) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while (node != null) {
            list.add(node);
            node = node.parent;
        }
        return list;
    }

    // Solution 2: Divide and Conquer
    public TreeNode LCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // look up separately in left child tree and right child tree
        TreeNode left = LCA(root.left, node1, node2);
        TreeNode right = LCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
