package Java;

import java.util.*;

/**
 * Created by ysun on 5/16/16.
 */
public class TopologicalSort {
    public class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int label) {
            this.label = label;
            this.neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();

        // iterate through all nodes in graph
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                // Count in-degree of all nodes.
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) { // iterate through all nodes
            // Pick any node which has in-degree of 0.
            if (!map.containsKey(node)) {
                // put node in result
                q.offer(node);
                result.add(node);
            }
        }

        while (!q.isEmpty()) {
            // print node, remove node
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                // Remove node n and all edges coming out of it.
                // Decrement in-degrees of all neighbors of vertex 'n' by 1.
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) { // pick any node which has in-degree of 0
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
