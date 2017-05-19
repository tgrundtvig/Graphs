package graphs.simpleimpl;

import java.util.List;

public class Graph {

    private List<Node> nodes;

    public Graph() {
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Node findNode(int id) {

        for (Node n : nodes) {
            if (n.getId() == id) {
                return n;
            }
        }

        return null;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
