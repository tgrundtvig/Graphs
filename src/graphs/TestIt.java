/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.algorithms.BreadthFirst;
import graphs.simpleimpl.GraphBuilderImpl;
import
import java.util.*;

/**
 *
 * @author Mohammed Salameh
 * This will work with the books implementation of Graphs.
 */
public class TestIt
{
    /*public static void main(String[] args)
    {
        GraphBuilder gb = new GraphBuilderImpl();
        
        BuildNode a = gb.createNode("A");
        BuildNode b = gb.createNode("B");
        BuildNode c = gb.createNode("C");
        BuildNode d = gb.createNode("D");
        BuildNode e = gb.createNode("E");
        
        gb.createEdge(a, b);
        gb.createEdge(b, a);
        gb.createEdge(a, d);
        gb.createEdge(d, a);
        gb.createEdge(b, c);
        gb.createEdge(c, d);
        gb.createEdge(c, c);
        gb.createEdge(c, e);
        gb.createEdge(e, d);
        
        Graph g = gb.build();
        Iterable<Node> res = BreadthFirst.runBreadthFirst(g.findNode("A"));
        
        for(Node n : res)
        {
            System.out.println(n.getName());
        }
    }
    */
}


class CycleDetecton {
        private boolean[] marked;
        private int[] edgeTo;
        private Stack<Integer> cycle;
        
        
        //Determines whether the undirected graph has a cycle
        //NOTE: GRAPH is the BOOKS IMplEMENTATION
        public CycleDetecton(Graph G) {
            if (hasSelfLoop(G)) return;
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            for (int v = 0; v < G.V(); v++)
                if (!marked[v])
                    dfs(G, -1, v);
        }
        
        
        // does this graph have a self loop?
        // side effect: initialize cycle to be self loop
        private boolean hasSelfLoop(Graph G) {
            for (int v = 0; v < G.V(); v++) {
                for (int w : G.adj(v)) {
                    if (v == w) {
                        cycle = new Stack<Integer>();
                        cycle.push(v);
                        cycle.push(v);
                        return true;
                    }
                }
            }
            return false;
        }
        
        
        
        //Returns true if the graph has a cycle.
        public boolean hasCycle() {
            return cycle != null;
        }
        
        //Returns a cycle in the graph
        public Iterable<Integer> cycle() {
            return cycle;
        }
    
    private void dfs(Graph G, int u, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            
            // short circuit if cycle already found
            if (cycle != null) return;
            
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }
            
            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }
        
}