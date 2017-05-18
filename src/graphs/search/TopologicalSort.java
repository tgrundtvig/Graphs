/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.search;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kasper
 */
public class TopologicalSort {

    public List<Node> doSort(Graph g) {
        List<Node> nodes = new ArrayList();
        List<Edge> edges = new ArrayList();
        List<Node> result = new ArrayList();

        g.getNodes().forEach(node -> nodes.add(node));

        for (int i = 0; i < nodes.size(); i++) {
            boolean t = true;
            nodes.get(i).getFromEdges().forEach(edge -> edges.add(edge));
            for (int j = 0; j < edges.size(); j++) {
                if (edges.get(j).getEndNode() == nodes.get(i)) {
                    if (!result.contains(edges.get(j).getBeginNode())) {
                        t = false;
                    }
                }
            }
            if (!result.contains(nodes.get(i)) && t) {
                result.add(nodes.get(i));
            }
        }
        return result;
    }

}
