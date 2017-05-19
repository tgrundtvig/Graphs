/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vixo
 */
public class MinSpanningTree {
    
//    public List<Edge> getMST(Graph graph) {
//        List<Edge> allEdges = new ArrayList<Edge>();
//        for (Node node : graph.getNodes()) {
//            for (Edge edge : node.getEdges()) {
//                allEdges.add(edge);
//            }
//        }
//        EdgeComparator comparator = new EdgeComparator();
//
//        Collections.sort(allEdges, comparator);
//        DisjointSet disjointSet = new DisjointSet();
//
//        for (Node node : graph.getNodes()) {
//            disjointSet.makeSet(node.getId());
//        }
//
//        List<Edge> resultEdges = new ArrayList<Edge>();
//
//        for (Edge edge : allEdges) {
//            long root1 = disjointSet.findSet(edge.getFrom().getId());
//            long root2 = disjointSet.findSet(edge.getTo().getId());
//
//            if(root1 == root2) {
//                continue;
//            } else {
//                resultEdges.add(edge);
//                disjointSet.union(edge.getFrom().getId(), edge.getTo().getId());
//            }
//        }
//        return resultEdges;
//    }
//    
//    public static List<Node> findMinimumSpanningTree(Graph graph) {
//        List<Node> visitedNodes = new ArrayList<>();
//        List<Edge> visitedEdges = new ArrayList<>();
//
//        //visitedNodes.add(startNode);
//        for (Node node : graph.getNodes()) {
//        //for (int i = 0; i < 3; i++) {
//            Edge nodeEdgeWeight = null;
//            visitedNodes.add(node);
//            
//            for (int y = 0; y < visitedNodes.size(); y++) {
//                Edge minWeight = null;
//                for (Edge edge : visitedNodes.get(y).getFromEdges()) {
//                    if (!visitedEdges.contains(edge)) {
//                        if (minWeight == null) {
//                            minWeight = edge;
//                        }
//                        if (edge.getEndNode().getName().compareTo(minWeight.getEndNode().getName()) > 0) {
//                            minWeight = edge;
//                        }
//                    }
//                }
//
//                nodeEdgeWeight = minWeight;
//            }
//            visitedEdges.add(nodeEdgeWeight);
//            visitedNodes.add(nodeEdgeWeight.getEndNode());
//        }
//
//        List<Node> result = new ArrayList<>();
//        for (Edge edge : visitedEdges) {
//            System.out.println("Edge weight: " + edge.getEndNode().getName());
//            result.add(edge.getEndNode());
//        }
//
//        return result;
//    }
    
    /**
     * Prims algorithm
     *
     * @param startNode - node we start from
     * @return sum of weight
     */
    public int findMinimumSpanningTree(Node startNode) {
        List<Node> visitedNodes = new ArrayList<>();
        List<Edge> visitedEdges = new ArrayList<>();

        visitedNodes.add(startNode);

        for (int i = 0; i < 3; i++) {
            Edge nodeEdgeWeight = null;
            for (int y = 0; y < visitedNodes.size(); y++) {
                Edge minWeight = null;
                for (Edge edge : visitedNodes.get(y).getFromEdges()) {
                    if (!visitedEdges.contains(edge)) {
                        if (minWeight == null) {
                            minWeight = edge;
                        }
                        if (edge.getWeight() < minWeight.getWeight()) {
                            minWeight = edge;
                        }
                    }
                }

                nodeEdgeWeight = minWeight;
            }
            visitedEdges.add(nodeEdgeWeight);
            visitedNodes.add(nodeEdgeWeight.getEndNode());
        }

        int result = 0;
        for (Edge edge : visitedEdges) {
            System.out.println("Edge weight: " + edge.getWeight());
            result += edge.getWeight();
        }

        return result;
    }
}
