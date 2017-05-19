package graphs.simpleimpl;

import java.util.LinkedList;

public class Digraph {

	private final int V;
	private int E;
	private LinkedList<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Integer>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
