/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Graph;
import graphs.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uffe
 */
public class CycleDetection {
     public List<List<Node>> detectCycle(Graph g){
        List<Node> nodes = new ArrayList();
        List<List<Node>> cycles = new ArrayList();
        
        g.getNodes().forEach(node -> nodes.add(node));
        
        for (int i = 0; i < nodes.size(); i++) {
            cycles.add(hasCycle(nodes.get(i), nodes.get(i).getName(), nodes.get(i).getName(), new ArrayList(), new ArrayList()));
        }
        
        return cycles;
    }
    

    public List<Node> hasCycle(Node n, String current, String last, List<Node> nodes, List<Node> visited) {
        List<Node> greyList = new ArrayList();
        n.getFromEdges().forEach(node -> greyList.add(node.getEndNode()));

        List<Node> n2 = new ArrayList();
        visited.add(n);
        nodes.add(n);
        System.out.println(last + " --> " + n.getName());

        for (int i = 0; i < greyList.size(); i++) {
            if (greyList.get(i).getName().equals(current) && !last.equals(current)) {
                nodes.add(greyList.get(i));
                return nodes;
            } else if (greyList.get(i).getName().equals(last)) {
                if (greyList.size() == 1) {
                    nodes.clear();
                    visited.remove(n);
                }
            } else if(!visited.contains(greyList.get(i))) {
                n2 = hasCycle(greyList.get(i), current, n.getName(), nodes, visited);
            }
        }
        return n2;
    }
}
