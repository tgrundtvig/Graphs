/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.algorithms.CircleDetection;
import graphs.simpleimpl.GraphBuilderImpl;

/**
 *
 * @author Tobias
 */
public class TestIt
{
    public static void main(String[] args)
    {
        GraphBuilder gb = new GraphBuilderImpl();
        
        BuildNode a = gb.createNode("A");
        BuildNode b = gb.createNode("B");
        BuildNode c = gb.createNode("C");
        BuildNode d = gb.createNode("D");
        BuildNode e = gb.createNode("E");
        BuildNode f = gb.createNode("F");
        
        gb.createEdge(a, c, 5);
        gb.createEdge(c, f, 10);
        gb.createEdge(f, d, 2);
        gb.createEdge(d, c, 3);
        //gb.createEdge(c, a, 5); // Only for min span tree
        //gb.createEdge(f, c, 10); // Only for min span tree
        //gb.createEdge(d, f, 2); // Only for min span tree
        //gb.createEdge(c, d, 3); // Only for min span tree
        
        Graph g = gb.build();
        //Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("A")); // Opg 1
        Iterable<Node> res = CircleDetection.hasCycle(g); // Opg 2
        //int res = new MinSpanningTree().findMinimumSpanningTree(g.findNode("A")); // Opg 3
        //System.out.println("Result: " + res);
        
        for(Node n : res)
        {
            System.out.println(n.getName());
        }
    }
}
