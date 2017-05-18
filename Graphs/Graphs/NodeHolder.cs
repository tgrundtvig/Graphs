using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graphs
{
    class NodeHolder
    {
        public List<Node> nodes;
        List<Node> TraversedNodes = new List<Node>();
        static bool looping;
        Node searchNode;

        public NodeHolder()
        {
            nodes = new List<Node>();
        }

        //solution to 3
        public List<Edge> shortestSpaningTree()
        {
            TraversedNodes.Clear();
            List<Edge> ReturnEdges = new List<Edge>();
            TraversedNodes.Add(nodes[0]);
            while (TraversedNodes.Count < nodes.Count)
            {
                List<Edge> searchedges = new List<Edge>();
                foreach(Node n in TraversedNodes)
                {
                    searchedges.AddRange(n.Edges);
                }

                ReturnEdges.Add(findLowestEdge(searchedges));

            }

            return ReturnEdges;
        }

        public Edge findLowestEdge(List<Edge> Serchnodes)
        {
            Edge lowestEdge = new Edge(new Node(""), new Node(""), 999);

            foreach (Edge e in Serchnodes)
            {
                if(e.weight < lowestEdge.weight)   
                {
                    if(TraversedNodes.Contains(e.node1) == false || TraversedNodes.Contains(e.node2) == false)
                    {
                        lowestEdge = e;
                    }
                }
            }

            if(TraversedNodes.Contains(lowestEdge.node1) == false)
            {
                TraversedNodes.Add(lowestEdge.node1);
            }

            if (TraversedNodes.Contains(lowestEdge.node2) == false)
            {
                TraversedNodes.Add(lowestEdge.node2);
            }

            return lowestEdge;
        }

        public List<Node> DijkstraSP(Node Start, Node Goal)
        {
            bool stillSearching = true;
            TraversedNodes.Clear();
            Start.ShortestPath = 0;
            LookAtEdges(Start);

            while(stillSearching)
            {
                Node SearchNode = new Node("");
                int ShortestPath = 9999;
                foreach(Node n in nodes)
                {
                    if(n.Visited == false && n.ShortestPath < ShortestPath)
                    {
                        SearchNode = n;
                        ShortestPath = n.ShortestPath;
                    }
                }

                LookAtEdges(SearchNode);

                if(Goal.Visited)
                {
                    stillSearching = false;
                }
            }

            List<Node> ReturnList = new List<Node>();
            bool hasChild = true;
            Node nodeOfIntrest = Goal;
            while(hasChild)
            {
                ReturnList.Add(nodeOfIntrest);
                if(nodeOfIntrest.childNode != null)
                {
                    nodeOfIntrest = nodeOfIntrest.childNode;
                }
                else
                {
                    hasChild = false;
                }
            }

            return ReturnList;
        }

        public void LookAtEdges(Node Target)
        {
            Target.Visited = true;
            foreach(Edge e in Target.Edges)
            {
                Node otherNode;
                if (e.node1 != Target)
                {
                    otherNode = e.node1;
                }
                else
                {
                    otherNode = e.node2;
                }

                if(otherNode.ShortestPath > Target.ShortestPath + e.weight)
                {
                    otherNode.ShortestPath = Target.ShortestPath + e.weight;
                    otherNode.childNode = Target;
                }
            }
        }

        //solution to 1
        public bool CheckForLoops()
        {
            looping = false;
            foreach(Node n in nodes)
            {
                searchNode = n;
                CheckNode(n);
            }
            return looping;
        }

        private void CheckNode(Node n)
        {
            foreach(Edge e in n.Edges)
            {
                if(looping == true)
                {
                    break;
                }
                else if (e.node2 != null && e.node2 != n)
                {
                    e.node2.childNode = n;
                    Console.WriteLine("connected " + e.weight);
                    CheckNode(e.node2);
                }
                else if (looping == false)
                {
                    TraversedNodes.Clear();
                    isTrue(n);
                }
                    
            }
        }

        private void isTrue(Node n)
        {
            if(n != null)
            {
                if(TraversedNodes.Contains(n))
                {
                    Console.WriteLine("i am at " + n.Edges.Count);
                    looping = true;
                }
                else
                {
                    TraversedNodes.Add(n);
                    isTrue(n.childNode);
                }
                
            }
        }

        //solution to 2
        public List<Node> topologicallySort()
        {
            List<Node> Sortedlist = new List<Node>();

            while(Sortedlist.Count < nodes.Count)
            {
                foreach (Node n in nodes)
                {
                    bool reachable = true;
                    foreach (Edge e in n.Edges)
                    {
                        if (e.node2 == n)
                        {
                            if (Sortedlist.Contains(e.node1) == false)
                            {
                                reachable = false;
                            }
                        }
                    }
                    if (reachable && Sortedlist.Contains(n) == false)
                    {
                        Sortedlist.Add(n);
                    }
                }
            }
            return Sortedlist;
        }
    }
}
