package graphs.algorithms;

import graphs.simpleimpl.GraphDFSImpl;

public class Cycle {

	private boolean[] marked;
	private boolean hasCycle;

	public Cycle(GraphDFSImpl G) {
		marked = new boolean[G.V()];
		for (int s = 0; s < G.V(); s++)
			if (!marked[s])
				dfs(G, s, s);
	}

	private void dfs(GraphDFSImpl G, int v, int u) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w, v);
			else if (w != u)
				setHasCycle(true);
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	private void setHasCycle(boolean hasCycle) {
		this.hasCycle = hasCycle;
	}

}
