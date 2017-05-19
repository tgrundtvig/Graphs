package graphs.simpleimpl;

import java.util.List;
import java.util.HashSet;

public class Node {

    private int id;
    private List<Edge> edges;

    public Node() {
    }

    public Node(int id, List<Edge> edges) {
        this.id = id;
        this.edges = edges;
    }

    public void addEdgeTo(int weight, Node to) {
        this.edges.add(new Edge(weight, this, to));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public HashSet<Node> getAdjacent() {
        HashSet<Node> adjacentList = new HashSet();
        for (Edge edge : edges) {
            if (!adjacentList.contains(edge.getTo())) {
                adjacentList.add(edge.getTo());
            }
        }
        return adjacentList;
    }
}
