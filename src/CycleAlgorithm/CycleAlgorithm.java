/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CycleAlgorithm;

import graphs.Edge;
import graphs.Graph;
import graphs.Node;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Joachim
 */
public class CycleAlgorithm {
    Set<Node> listOfVertices = new HashSet();

    public Set<Node> hasCycle(Graph graph) {
        Set<Node> whiteSet = new HashSet<>();
        Set<Node> graySet = new HashSet<>();
        Set<Node> blackSet = new HashSet<>();
        
        

        for (Node node : graph.getNodes()) {
            whiteSet.add(node);
        }

        while (whiteSet.size() > 0) {
            Node current = whiteSet.iterator().next();
            if (dfs(current, whiteSet, graySet, blackSet)) {
                return listOfVertices;
            }
        }
        return null;
    }

    private boolean dfs(Node current, Set<Node> whiteSet, Set<Node> graySet, Set<Node> blackSet) {
        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        Iterable<Edge> listOfNodes = current.getFromEdges();
        listOfVertices = null;
        for (Edge neighbor : listOfNodes) {
            if(neighbor.getEndNode() != null){
                listOfVertices.add(neighbor.getEndNode());
                //if in black set means already explored so continue.
                if (blackSet.contains(neighbor.getEndNode())) {
                    continue;
                }
                //if in gray set then cycle found.
                if (graySet.contains(neighbor.getEndNode())) {
                    return true;
                }
                if (dfs(neighbor.getEndNode(), whiteSet, graySet, blackSet)) {
                    return true;
                }
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private void moveVertex(Node vertex, Set<Node> sourceSet, Set<Node> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

}
