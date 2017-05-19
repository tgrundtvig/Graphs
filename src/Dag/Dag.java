/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dag;

import java.util.LinkedList;
import java.util.*;

/**
 *
 * @author Joachim
 */
public class Dag {

    private int V;   // Nunmer of vertices
    private LinkedList<Integer> adj[];

    public Dag(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    private void topologicalSort(int v, boolean visited[], Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }
        stack.push(new Integer(v));
    }

    private void topologicalSort() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                topologicalSort(i, visited, stack);
            }
        }
        while (stack.empty() == false) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String args[]) {
        // Create a graph
        Dag g = new Dag(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topologicalSort();
    }

}
