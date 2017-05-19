package graphs.handin6;

import graphs.simpleimpl.Graph;
import graphs.simpleimpl.Node;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 * You should create an algorithm that takes a DAG (Directed Acyclic Graph) and
 * returns the vertices in a topologically sorted order.
 */
/**
 *
 * @author Luke
 */
public class TopologicalSort {

    private Set<Node> typoOrderedSet = new HashSet<>();

    public Stack<Node> topSort(Graph graph) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet();
        for (Node node : graph.getNodes()) {
            if (visited.contains(node)) {
                continue;
            } else {
                topSortUtil(node, stack, visited);
            }
        }
        return stack;
    }

    private void topSortUtil(Node node, Stack<Node> stack, Set<Node> visited) {
        visited.add(node);
        for (Node child : node.getAdjacent()) {
            if (visited.contains(child)) {
                continue;
            } else {
                topSortUtil(child, stack, visited);
            }
        }
        stack.push(node);
    }
}
