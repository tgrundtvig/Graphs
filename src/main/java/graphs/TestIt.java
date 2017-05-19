/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.algorithms.Cycle;
import graphs.simpleimpl.GraphBuilderImpl;

/**
 *
 * @author Tobias
 */
public class TestIt {
	public static void main(String[] args) {
		GraphBuilder gb = new GraphBuilderImpl();

		BuildNode a = gb.createNode("A");
		BuildNode b = gb.createNode("B");
		BuildNode c = gb.createNode("C");
		BuildNode d = gb.createNode("D");
		BuildNode e = gb.createNode("E");

		gb.createEdge(a, b);
		gb.createEdge(b, c);
		gb.createEdge(c, a);

		Graph g = gb.build();
		Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("E"));

		for (Node n : res) {
			System.out.println(n.getName());
		}
	}
}
