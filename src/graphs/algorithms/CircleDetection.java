package graphs.algorithms;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Vixo
 */
public class CircleDetection {

    private static Map<Node, Node> parentMap = new HashMap<>();
    private static HashSet<Node> cycleNodes = new HashSet();

    public static HashSet<Node> hasCycle(Graph graph) {
        HashSet<Node> unknown = new HashSet();
        HashSet<Node> lookingAt = new HashSet();
        HashSet<Node> lookedAt = new HashSet();

        for (Node n : graph.getNodes()) {
            unknown.add(n);
        }

        while (unknown.size() > 0) {
            Node current = unknown.iterator().next();
            if (dfs(current, unknown, lookingAt, lookedAt)) {
                return cycleNodes;
            }
        }
        return null;
    }

    private static boolean dfs(Node current, HashSet<Node> whiteSet, HashSet<Node> greySet, HashSet<Node> blackSet) {
        moveNode(current, whiteSet, greySet);
        for (Node neighbor : getAdjacentNodes(current)) {
            parentMap.put(neighbor, current);
            if (blackSet.contains(neighbor)) {
                continue;
            }
            if (greySet.contains(neighbor)) {
                cycleNodes.add(neighbor);
                while (current != neighbor) {
                    cycleNodes.add(current);
                    current = parentMap.get(current);

                }
                return true;
            }
            if (dfs(neighbor, whiteSet, greySet, blackSet)) {
                return true;
            }
        }
        moveNode(current, greySet, blackSet);
        return false;
    }

    private static void moveNode(Node node, Set<Node> fromSet, Set<Node> toSet) {
        fromSet.remove(node);
        toSet.add(node);
    }
    
    private static Set<Node> getAdjacentNodes(Node node) {
        Set<Node> nodes = new HashSet<>();
        for (Edge edge : node.getFromEdges()) {
            nodes.add(edge.getEndNode());
        }
        
        return nodes;
    }

}
