using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graphs
{
    class Program
    {
        static void Main(string[] args)
        {
            NodeHolder nh = new NodeHolder();
            
            Node node0 = new Node("1");
            nh.nodes.Add(node0);
            Node node1 = new Node("2");
            nh.nodes.Add(node1);
            Node node2 = new Node("3");
            nh.nodes.Add(node2);
            Node node3 = new Node("4");
            nh.nodes.Add(node3);
            Node node4 = new Node("5");
            nh.nodes.Add(node4);
            Node node5 = new Node("6");
            nh.nodes.Add(node5);
            Node node6 = new Node("7");
            nh.nodes.Add(node6);
            Node node7 = new Node("8");
            nh.nodes.Add(node7);


            Edge edge1 = new Edge(node0, node1, 4);
            Edge edge15 = new Edge(node0, node4, 5);
            Edge edge2 = new Edge(node0, node2, 8);
            Edge edge3 = new Edge(node1, node3, 9);
            Edge edge4 = new Edge(node1, node5, 7);
            Edge edge5 = new Edge(node1, node6, 5);
            Edge edge6 = new Edge(node2, node4, 9);
            Edge edge7 = new Edge(node4, node6, 7);
            Edge edge9 = new Edge(node6, node7, 3);
            Edge edge10 = new Edge(node2, node1, 7);
            Edge edge11 = new Edge(node7, node5, 3);
            //Edge loopEdge = new Edge(node7, node2, 3);

            List<Edge> results = nh.shortestSpaningTree();
            //List<Node> results2 = nh.DijkstraSP(node0, node4);
            List<Node> results3 = nh.topologicallySort();

            Console.WriteLine(nh.CheckForLoops());

            foreach (Edge e in results)
            {
                Console.WriteLine(e.weight);
            }

            //foreach (Node n in results2)
            //{
            //    Console.WriteLine(n.ShortestPath);
            //}

            foreach (Node n in results3)
            {
                Console.WriteLine(n.name);
            }

            Console.ReadLine();
        }
    }
}
