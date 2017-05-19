/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.algorithms.CycleDetection;
import graphs.algorithms.DAGSorter;
import graphs.simpleimpl.GraphBuilderImpl;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class TestIt
{
    public static void main(String[] args)
    {
        GraphBuilder gb = new GraphBuilderImpl();
        
        BuildNode b = gb.createNode("A");
        BuildNode a = gb.createNode("B");
        BuildNode d = gb.createNode("C");
        BuildNode c = gb.createNode("D");
        BuildNode e = gb.createNode("E");
        
        gb.createEdge(a, b);
        gb.createEdge(b, c);
        gb.createEdge(b, d);
        gb.createEdge(c, c);
        gb.createEdge(c, a);
        gb.createEdge(d, a);
        gb.createEdge(e, a);
        
        Graph g = gb.build();
        Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("D"));
        
        for(Node n : res)
        {
            System.out.println(n.getName());
        }
        CycleDetection cd = new CycleDetection();
        List<List<Node>> calculatedCycles = cd.detectCycle(g);
         for (int i = 0; i < calculatedCycles.size(); i++) {
             for (int j = 0; j < calculatedCycles.get(i).size(); j++) {
                 System.out.println(calculatedCycles.get(i).get(j).getName());
             }
             System.out.println("----------------");
         }
         
    }
}
