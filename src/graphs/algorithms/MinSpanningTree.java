/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Edge;
import graphs.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author abj
 */
public class MinSpanningTree {
   
    public int findMinimumSpanningTree(Node startNode) {
       
        List<Node> vNodes = new ArrayList<>();
        List<Edge> vEdges = new ArrayList<>();

        vNodes.add(startNode);

        for (int i = 0; i < 3; i++) {
            Edge nEdgeWeight = null;
            for (int y = 0; y < vNodes.size(); y++) {
                Edge minWeight = null;
                for (Edge edge : vNodes.get(y).getFromEdges()) {
                    if (!vEdges.contains(edge)) {
                        if (minWeight != null) {
                        } else {
                            minWeight = edge;
                        }
                        if (edge.getWeight() >= minWeight.getWeight()) {
                        } else {
                            minWeight = edge;
                        }
                    }
                }

                nEdgeWeight = minWeight;
            }
            vEdges.add(nEdgeWeight);
            vNodes.add(nEdgeWeight.getEndNode());
        }

        int result = 0;
        result = vEdges.stream().map((edge) -> {
            //System.out.println("Edge weight: " + edge.getWeight());
            return edge;
        }).map((edge) -> edge.getWeight()).reduce(result, Integer::sum);

        return result;
    }
}
