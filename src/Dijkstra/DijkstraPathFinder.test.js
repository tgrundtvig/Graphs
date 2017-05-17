import Graph from "../Graph.js";
import DijkstraPathFinder from "./DijkstraPathFinder.js";

test("Dijkstra should return correct path", () => {
  const graph = new Graph();

  // Add nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);

  // Add edges
  graph.addEdge(1, 4);
  graph.addEdge(1, 3);
  graph.addEdge(4, 2);
  graph.addEdge(3, 4);

  // Find path
  const pathFinder = new DijkstraPathFinder();
  const path = pathFinder.find(graph, graph.nodes[1], graph.nodes[2]);

  expect(path).toEqual([graph.nodes[1], graph.nodes[4], graph.nodes[2]]);
});
