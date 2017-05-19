package graphs.handin6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graphs.simpleimpl.*;

/**
 *
 * @author Luke
 */
public class CycleDetectorMain {

    public static void main(String[] args) {
        Graph graph = CycleDetectorMain.generateDirectedGraph();
        CycleDetector dfs = new CycleDetector();
        Stack<Node> cycleStack = dfs.hasCycle(graph);
        for (Node node : cycleStack) {
            System.out.println(node.getId());
        }

    }

    public static Graph generateDirectedGraph() {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        Node n7 = new Node(7, new ArrayList<>());
        Node n8 = new Node(8, new ArrayList<>());
        Node n9 = new Node(9, new ArrayList<>());

        n1.addEdgeTo(3, n2);
        n1.addEdgeTo(5, n7);
        n1.addEdgeTo(9, n8);
        n2.addEdgeTo(4, n3);
        n3.addEdgeTo(2, n2); // remove this one to find the next cycle 3, 4, 5, 6
        n3.addEdgeTo(1, n4);
        n4.addEdgeTo(7, n5);
        n5.addEdgeTo(9, n6);
        n6.addEdgeTo(3, n3);
        n8.addEdgeTo(7, n9);

        List<Node> nodeList = new ArrayList<>();

        nodeList.add(n1);
        nodeList.add(n2);
        nodeList.add(n3);
        nodeList.add(n4);
        nodeList.add(n5);
        nodeList.add(n6);
        nodeList.add(n7);
        nodeList.add(n8);
        nodeList.add(n9);

        return new Graph(nodeList);
    }
}
