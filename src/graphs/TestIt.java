/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.algorithms.MinSpanningTree;
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
        BuildNode e = gb.createNode("E");
        
        gb.createEdge(a, c, 10);
        gb.createEdge(b, e, 15);
        gb.createEdge(e, a,3);
        gb.createEdge(b, a,2);
       
       
        Graph g = gb.build(); 
       
        //int resMST = new MinSpanningTree().findMinimumSpanningTree(g.findNode("C"));
        
       Iterable<Node> res = CycleDetection.hasCycle(g);

        // Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("A"));
        
        for(Node n : res)
        {
            System.out.println(n.getName());
        }
        
        //System.out.println("Result: " + resMST);
    }
}
