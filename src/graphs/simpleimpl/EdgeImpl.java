/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.simpleimpl;

import graphs.Edge;
import graphs.Node;

/**
 *
 * @author Tobias
 */
public class EdgeImpl implements Edge
{
    private int weight;
    private final Node begin;
    private final Node end;

    public EdgeImpl(Node begin, Node end)
    {
        this.begin = begin;
        this.end = end;
    }
    
     public EdgeImpl(Node begin, Node end, int weight)
    {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public Node getBeginNode()
    {
        return begin;
    }

    @Override
    public Node getEndNode()
    {
        return end;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public int getWeight() {
        return weight;
    }
    
}
