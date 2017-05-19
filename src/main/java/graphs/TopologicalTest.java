package graphs;

import graphs.algorithms.DepthFirstOrder;
import graphs.simpleimpl.Digraph;

public class TopologicalTest {

	public static void main(String[] args) {

		Digraph graph = new Digraph(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(1, 4);
		
		DepthFirstOrder top = new DepthFirstOrder(graph);
		
		for (Integer node : top.reversePost()) {
			System.out.println(node);
		}

	}
}
