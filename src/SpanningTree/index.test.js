import Graph from "./Graph";

import findMinimumSpanningTree from "./index";

test("Should return null if no graph", () => {
  expect(findMinimumSpanningTree(null)).toBeNull();
  expect(findMinimumSpanningTree(undefined)).toBeNull();
});

test("Should return correct spanning tree", () => {
  const graph = new Graph();

  // Nodes
  graph.addNode("a");
  graph.addNode("b");
  graph.addNode("c");
  graph.addNode("d");
  graph.addNode("e");
  graph.addNode("f");

  // Edges
  const edges = [
    graph.addEdge("a", "b", 4),
    graph.addEdge("a", "f", 2),
    graph.addEdge("b", "f", 5),
    graph.addEdge("b", "c", 6),
    graph.addEdge("c", "f", 1),
    graph.addEdge("c", "d", 3),
    graph.addEdge("d", "e", 2),
    graph.addEdge("e", "f", 4)
  ];

  const response = findMinimumSpanningTree(graph);

  const expecties = [edges[1], edges[0], edges[4], edges[5], edges[6]];

  expect(response).toContain(expecties[0]);
  expect(response).toContain(expecties[1]);
  expect(response).toContain(expecties[2]);
  expect(response).toContain(expecties[3]);
  expect(response).toContain(expecties[4]);
  expect(response.length).toEqual(expecties.length);
});
