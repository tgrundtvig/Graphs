package graphs.handin6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import graphs.simpleimpl.*;
import java.util.Stack;

/**
 * You should create a Cycle detection algorithm, that takes a graph as input
 * and as output it returns a cycle in the graph (list of vertices) or null, if
 * there is no cycles in the graph.
 */
/**
 *
 * @author Lukasz Koziarski
 */
public class CycleDetector {

    private Map<Node, Node> parentMap = new HashMap();
    private Stack<Node> cycleNodes = new Stack<>();


    public Stack<Node> hasCycle(Graph graph) {
        Set<Node> whiteSet = new HashSet<>();
        Set<Node> greySet = new HashSet<>();
        Set<Node> blackSet = new HashSet<>();

        for (Node node : graph.getNodes()) {
            whiteSet.add(node);
        }

        while (whiteSet.size() > 0) {
            Node current = whiteSet.iterator().next();
            if (dfs(current, whiteSet, greySet, blackSet)) {
                return cycleNodes;
            }
        }
        return null;
    }

    private boolean dfs(Node current, Set<Node> whiteSet, Set<Node> greySet, Set<Node> blackSet) {
        moveNode(current, whiteSet, greySet);
        for (Node neighbor : current.getAdjacent()) {
            parentMap.put(neighbor, current);
            if (blackSet.contains(neighbor)) {
                continue;
            }
            if (greySet.contains(neighbor)) {
                cycleNodes.push(neighbor);
                while (current != neighbor) {
                    cycleNodes.push(current);
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

    private void moveNode(Node node, Set<Node> fromSet, Set<Node> toSet) {
        fromSet.remove(node);
        toSet.add(node);
    }
}
