import Graph from "../Graph";

import detectCycle from "./index";

test("Should return null if no graph", () => {
  expect(detectCycle(null)).toBeNull();
  expect(detectCycle(undefined)).toBeNull();
});

test("Should return null if no startNode", () => {
  expect(detectCycle(new Graph(), null)).toBeNull();
  expect(detectCycle(new Graph(), undefined)).toBeNull();
});

test("Should return null if node is not in graph", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);

  const response = detectCycle(graph);

  expect(response).toBeNull();
});

test("Should return cycle if found", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(1, 2);
  graph.addEdge(3, 4);
  graph.addEdge(4, 5);
  graph.addEdge(5, 3);

  const response = detectCycle(graph);

  expect(response[0]).toEqual([graph.nodes[3], graph.nodes[4], graph.nodes[5]]);
});

test("Should return multiple cycles if found", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);

  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(1, 2);
  graph.addEdge(2, 1);
  graph.addEdge(4, 5);
  graph.addEdge(5, 4);

  const response = detectCycle(graph);

  expect(response[0]).toEqual([graph.nodes[1], graph.nodes[2]]);
  expect(response[1]).toEqual([graph.nodes[4], graph.nodes[5]]);
});

test("Should return cycle null if no cycle is found", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode(1);
  graph.addNode(2);
  graph.addNode(3);
  graph.addNode(4);
  graph.addNode(5);

  // Edges
  graph.addEdge(1, 2);
  graph.addEdge(2, 3);

  graph.addEdge(4, 5);
  graph.addEdge(5, 3);

  const response = detectCycle(graph, graph.nodes[1]);

  expect(response).toBeNull();
});

test("Should cycle if a cycle", () => {
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

  const response = detectCycle(graph);

  expect(response[0]).toEqual([graph.nodes[3], graph.nodes[4], graph.nodes[5]]);
});
