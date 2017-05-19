package algorithms;


import graphs.Graph;
import graphs.Node;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleDetection {

	private Map<Node, Node> parentMap = new HashMap();
	private Set<Node> cycleNodes = new HashSet();

	public Set<Node> hasCycle(Graph graph) {
		Set<Node> whiteSet = new HashSet<Node>();
		Set<Node> greySet = new HashSet<Node>();
		Set<Node> blackSet = new HashSet<Node>();


		for (Node node : graph.getNodes()) {
			whiteSet.add(node);
		}

		while(whiteSet.size() > 0) {
			Node current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, greySet, blackSet)) {
				return cycleNodes;
			}
		}
		return null;
	}

	private boolean dfs(Node current, Set<Node> whiteSet, Set<Node> greySet, Set<Node> blackSet) {
		moveNode(current, whiteSet, greySet);
		for (Node neighbor: current.getAdjacent()) {
			parentMap.put(neighbor, current);
			if(blackSet.contains(neighbor)) {
				continue;
			}
			if(greySet.contains(neighbor)) {
				cycleNodes.add(neighbor);
				while (current != neighbor) {
					cycleNodes.add(current);
					current = parentMap.get(current);

				}
				return true;
			}
			if(dfs(neighbor, whiteSet, greySet, blackSet)) {
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