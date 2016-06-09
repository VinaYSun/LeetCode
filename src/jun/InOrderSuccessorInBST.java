package jun;

/**
 * Created by ysun on 6/8/16.
 */
public class InOrderSuccessorInBST {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        // 注意 binary search Tree
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // not found
        // example [2, 1, 3], finding 4's successor
        if (root == null) {
            return null;
        }

        // found
        // doesn't have right child
        // example [2, 1, 3], finding 3's successor
        if (root.right == null) {
            // returning presaved succesor, because when root was found, it was moved to the right already ...
            return successor;
        }

        // found
        // have right child
        // example [2, 1, 4, 5, 6] --- in BST
        //      2
        //     / \
        //    1   4
        //         \
        //          6
        //         /
        //        5
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
