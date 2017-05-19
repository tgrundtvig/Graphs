package graphs.simpleimpl;

import java.util.LinkedList;

public class GraphDFSImpl {

	private static int V; // number of vertices
	private  int E; // number of edges
	private static LinkedList<Integer> adj[];

	public GraphDFSImpl(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
