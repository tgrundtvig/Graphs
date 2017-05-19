/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author abj
 */
public class CycleDetection {
    
    private static Map<Node, Node> parentMap = new HashMap<>();
    private static HashSet<Node> cycleNodes = new HashSet();
    
    
    private static Set<Node> getAdjacentNodes(Node node) {
        Set<Node> nodes = new HashSet<>();
        for (Edge edge : node.getFromEdges()) {
            nodes.add(edge.getEndNode());
        }
        
        return nodes;
    }
   
    
     private static boolean dfs(Node current, HashSet<Node> whiteSet, HashSet<Node> greySet, HashSet<Node> blackSet) {
        moveNode(current, whiteSet, greySet);
        for (Node neighbor : getAdjacentNodes(current)) {
            parentMap.put(neighbor, current);
            if (blackSet.contains(neighbor)) {
                continue;
            }
            if (greySet.contains(neighbor)) {
                cycleNodes.add(neighbor);
                while (current != neighbor) {
                    cycleNodes.add(current);
                    current = parentMap.get(current);

                }
                return true;
            }
            if (dfs(neighbor, whiteSet, greySet, blackSet)) {
                return true;
            }
        }
        moveNode(current, greySet, blackSet);
        return false;
    }
    
     
    private static void moveNode(Node node, Set<Node> fromSet, Set<Node> toSet) {
        fromSet.remove(node);
        toSet.add(node);
    }
    
   
    
     public static HashSet<Node> hasCycle(Graph g){
        HashSet<Node> undefined = new HashSet();
        HashSet<Node> atNode = new HashSet();
        HashSet<Node> beenAt = new HashSet();
 
        for (Node n : g.getNodes()) {
            undefined.add(n);
        }
 
        while (undefined.size() > 0) {
             Node current = undefined.iterator().next();
            if (dfs(current, undefined, atNode, beenAt)) {
                 return cycleNodes;
             }
         }
         return null;
    }
}
