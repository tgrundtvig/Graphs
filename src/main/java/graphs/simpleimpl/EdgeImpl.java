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
public class EdgeImpl implements Edge {
	private final Node begin;
	private final Node end;

	public EdgeImpl(Node begin, Node end) {
		this.begin = begin;
		this.end = end;
	}

	public Node getBeginNode() {
		return begin;
	}

	public Node getEndNode() {
		return end;
	}

}
