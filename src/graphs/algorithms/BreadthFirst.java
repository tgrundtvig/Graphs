/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.algorithms;

import graphs.Edge;
import graphs.Node;

import java.util.*;

/**
 *
 * @author Tobias
 */
public class BreadthFirst
{
    public static List<Node> runBreadthFirst(Node start)
    {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        List<Node> res = new ArrayList<>();
        queue.add(start);
        visited.add(start);
        recurse(queue, visited, res);
        return res;
    }
    
    public static void recurse(Queue<Node> queue, Set<Node> visited, List<Node> res)
    {
        if(queue.isEmpty()) return;
        Node next = queue.remove();
        res.add(next);
        for(Edge e : next.getFromEdges())
        {
            Node end = e.getEndNode();
            if(!visited.contains(end))
            {
                visited.add(end);
                queue.add(end);
            }
        }
        recurse(queue, visited, res);
    }
}
