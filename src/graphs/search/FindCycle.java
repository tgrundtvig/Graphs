/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.search;

import graphs.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class FindCycle {

    public List<List<Node>> detectCycle(Graph g){
        List<Node> nodes = new ArrayList();
        List<List<Node>> cycles = new ArrayList();
        
        g.getNodes().forEach(node -> nodes.add(node));
        
        for (int i = 0; i < nodes.size(); i++) {
            cycles.add(hasCycle(nodes.get(i), nodes.get(i).getName(), nodes.get(i).getName(), new ArrayList(), new ArrayList()));
        }
        
        return cycles;
    }
    

    public List<Node> hasCycle(Node n, String current, String previous, List<Node> nodes, List<Node> visited) {
        List<Node> visit = new ArrayList();
        n.getFromEdges().forEach(node -> visit.add(node.getEndNode()));

        List<Node> n2 = new ArrayList();
        visited.add(n);
        nodes.add(n);
        System.out.println(previous + " --> " + n.getName());

        for (int i = 0; i < visit.size(); i++) {
            if (visit.get(i).getName().equals(current) && !previous.equals(current)) {
                nodes.add(visit.get(i));
                return nodes;
            } else if (visit.get(i).getName().equals(previous)) {
                if (visit.size() == 1) {
                    nodes.clear();
                    visited.remove(n);
                }
            } else if(!visited.contains(visit.get(i))) {
                n2 = hasCycle(visit.get(i), current, n.getName(), nodes, visited);
            }
        }
        return n2;
    }

}
