package graphs;

import graphs.algorithms.Cycle;
import graphs.simpleimpl.GraphDFSImpl;

public class DFSCycleTest {

	public static void main(String[] args) {
		GraphDFSImpl graph = new GraphDFSImpl(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);

		Cycle c = new Cycle(graph);

		if (c.hasCycle()) {
			System.out.println("CYCLE");
		} else {
			System.out.println("NO CYCLE");
		}

	}

}
