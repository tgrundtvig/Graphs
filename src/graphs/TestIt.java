/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.search.FindCycle;
import graphs.search.TopologicalSort;
import graphs.simpleimpl.GraphBuilderImpl;
import java.util.List;

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
//        BuildNode f = gb.createNode("F");

        gb.createEdge(a, b);
        gb.createEdge(b, a);
        gb.createEdge(a, d);
        gb.createEdge(d, a);
        gb.createEdge(b, c);
        gb.createEdge(c, d);
        gb.createEdge(c, c);
        gb.createEdge(c, e);
        gb.createEdge(e, d);
        
//            gb.createEdge(a, b);
//            gb.createEdge(b, c);
//            gb.createEdge(c, e);
//            gb.createEdge(e, f);
//            gb.createEdge(d, e);

        Graph g = gb.build();
        
        //Opgave 1 - Fungerer.. næsten
        FindCycle fc = new FindCycle();
        List<List<Node>> cycles = fc.detectCycle(g);
//        for (int i = 0; i < cycles.size(); i++) {
//            for (int j = 0; j < cycles.get(i).size(); j++) {
//                System.out.println(cycles.get(i).get(j).getName());
//            }
//            System.out.println("---");
//        }
        
        //Opgave 2 - Brug udkommenteret datasæt til test
        TopologicalSort ts = new TopologicalSort();
        List<Node> res2 = ts.doSort(g);
        for (int i = 0; i < res2.size(); i++) {
            System.out.println(res2.get(i).getName());
        }


//        Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("A"));
//        
//        for(Node n : res)
//        {
//            System.out.println(n.getName());
//        }
    }
}
