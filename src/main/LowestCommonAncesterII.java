package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysun on 6/9/16.
 */
class ParentTreeNode {
    public ParentTreeNode parent, left, right;
}
public class LowestCommonAncesterII {
    public ParentTreeNode lowestCommonAncesterII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {

        List<ParentTreeNode> aParent = new ArrayList<ParentTreeNode>();
        List<ParentTreeNode> bParent = new ArrayList<ParentTreeNode>();

        aParent = getParentPath(A);
        bParent = getParentPath(B);
        int i, j;
        for (i = aParent.size() - 1, j = bParent.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (aParent.get(i) != bParent.get(j)) {
                return aParent.get(i).parent;
            }
        }

        return aParent.get(i + 1);
    }

    public List<ParentTreeNode> getParentPath(ParentTreeNode node) {
        List<ParentTreeNode> result = new ArrayList<ParentTreeNode>();
        while (node != null) {
            result.add(node);
            node = node.parent;
        }
        return result;
    }
}
