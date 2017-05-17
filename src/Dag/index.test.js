import Graph from "../Graph";

import getTopologicallyOrder from "./index";

test("Should return null if no graph", () => {
  expect(getTopologicallyOrder(null)).toBeNull();
  expect(getTopologicallyOrder(undefined)).toBeNull();
});

test("Should return null if no startNode", () => {
  expect(getTopologicallyOrder(new Graph(), null)).toBeNull();
  expect(getTopologicallyOrder(new Graph(), undefined)).toBeNull();
});

test("Should return null if not valid DAG", () => {
  // There will be a cycle in this graph, and therefor it will not be a valid DAG

  const graph = new Graph();

  // Nodes
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(3, 4);
  graph.addEdge(4, 5);
  graph.addEdge(5, 3);

  const response = getTopologicallyOrder(graph, graph.nodes[3]);

  expect(response).toBeNull();
});

test("Should return ordered array", () => {
  // There will be a cycle in this graph, and therefor it will not be a valid DAG

  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(3, 4);
  graph.addEdge(4, 5);
  graph.addEdge(5, 1);
  graph.addEdge(1, 2);

  const response = getTopologicallyOrder(graph, graph.nodes[3]);

  expect(response).toEqual([
    graph.nodes[3],
    graph.nodes[4],
    graph.nodes[5],
    graph.nodes[1],
    graph.nodes[2]
  ]);
});

test("Should return ordered array from 5", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(3, 4);
  graph.addEdge(4, 5);
  graph.addEdge(5, 1);
  graph.addEdge(1, 2);

  const response = getTopologicallyOrder(graph, graph.nodes[5]);

  expect(response).toEqual([
    graph.nodes[5],
    graph.nodes[1],
    graph.nodes[2]
  ]);
});


test("Should return ordered array when skipping", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);
  graph.addNode(6);
  graph.addNode(7);

  // Edges
  graph.addEdge(1, 2);
  graph.addEdge(2, 5);
  graph.addEdge(3, 4);
  graph.addEdge(4, 5);
  graph.addEdge(5, 6);
  graph.addEdge(6, 7);

  const response = getTopologicallyOrder(graph, graph.nodes[1]);

  expect(response).toEqual([
    graph.nodes[1],
    graph.nodes[2],
    graph.nodes[5],
    graph.nodes[6],
    graph.nodes[7]
  ]);
});

