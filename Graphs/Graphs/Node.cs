using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graphs
{
    class Node
    {
        public List<Edge> Edges;

        public int ShortestPath;

        public Node childNode;

        public Boolean Visited;

        public string name;

        public Node(string name)
        {
            this.name = name;
            Edges = new List<Edge>();
            ShortestPath = 9999;
            Visited = false;
        }
    }
}
