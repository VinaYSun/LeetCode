package main;

import java.util.Stack;

/**
 * Created by ysun on 5/8/16.
 */
public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode cur;

    public BinarySearchTreeIterator(TreeNode root) {
        cur = root;
    }

    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }

    public TreeNode next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;

        return node;
    }


}
