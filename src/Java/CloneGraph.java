package Java;

import java.util.*;

/**
 * Created by ysun on 5/16/16.
 */
public class CloneGraph {
    public class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // get nodes
        ArrayList<UndirectedGraphNode> oldnodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        // copy nodes
        for (UndirectedGraphNode n : oldnodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        // copy neighbors.
        for (UndirectedGraphNode n : oldnodes) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                newNode.neighbors.add(map.get(neighbor)); // coping new nodes as neighbors
            }
        }
        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!set.contains(neighbor)) { // checking duplicateds in neighbors
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
