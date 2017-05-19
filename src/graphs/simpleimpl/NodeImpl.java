/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.simpleimpl;

import graphs.BuildNode;
import graphs.Edge;
import graphs.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class NodeImpl implements Node, BuildNode
{
    private final String name;
    private final List<Edge> edges;

    public NodeImpl(String name)
    {
        this.name = name;
        this.edges = new ArrayList<>();
    }
    
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Iterable<Edge> getFromEdges()
    {
        return edges;
    }
    
    public void addEdgeTo(Node end)
    {
        edges.add(new EdgeImpl(this, end));
    }
    
}
