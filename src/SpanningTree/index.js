const sortByWeight = connections => {
  const sortedConnections = [...connections];

  sortedConnections.sort((a, b) => {
    if (a.weight > b.weight) return 1;
    if (a.weight < b.weight) return -1;

    return 0;
  });

  return sortedConnections;
};

class DisjoinSet {
  sets = [];

  constructor(node) {
    this.sets.push(node);
  }

  union(disjointSet) {
    this.sets = [...this.sets, ...disjointSet.sets];
  }

  size() {
    return this.sets.length;
  }

  contains(node) {
    return this.sets.includes(node);
  }
}

const findMinimumSpanningTree = graph => {
  if (!graph) {
    return null;
  }

  const spanningTree = [];
  const disjointSets = {};

  const nodes = Object.values(graph.nodes);
  for (let i = 0; i < nodes.length; i++) {
    const node = nodes[i];

    disjointSets[node.name] = new DisjoinSet(node);
  }

  const connections = sortByWeight(graph.connections);

  for (let i = 0; i < connections.length; i++) {
    const connection = connections[i];

    const sourceDisjointSet = disjointSets[connection.source.name];
    const destinationDisjointSet = disjointSets[connection.destination.name];

    // Is it already connected?
    if (sourceDisjointSet !== destinationDisjointSet) {
      if (sourceDisjointSet.size() > destinationDisjointSet.size()) {
        // If it is already in the set, then just continue;

        if (sourceDisjointSet.contains(connection.destination)) {
          continue;
        }
        sourceDisjointSet.union(destinationDisjointSet);
        disjointSets[connection.destination.name] = sourceDisjointSet;
      } else {
        // If it is already in the set, then just continue;
        if (destinationDisjointSet.contains(connection.source)) {
          continue;
        }

        destinationDisjointSet.union(sourceDisjointSet);
        disjointSets[connection.source.name] = destinationDisjointSet;
      }

      spanningTree.push(connection);
    }
  }

  return spanningTree;
};

export default findMinimumSpanningTree;
