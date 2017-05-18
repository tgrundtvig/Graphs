const HIGH = 9999999;

const getShortestDistance = (node, distances) => {
  return distances[node.name];
};

const getNodesWithLowestDistance = (nodes, distances) => {
  let minimum = null;

  for (let i = 0; i < nodes.length; i++) {
    const node = nodes[i];

    if (minimum === null) {
      minimum = node;
    } else {
      if (
        getShortestDistance(node, distances) <
        getShortestDistance(minimum, distances)
      ) {
        minimum = node;
      }
    }
  }

  return minimum;
};

const getDistance = (connections, node, target) => {
  //   console.log("Searching for ");
  //   console.log(node, target);
  for (let i = 0; i < connections.length; i++) {
    const connection = connections[i];
    // console.log("-------------------------");
    // console.log(connection.source, connection.source === node);
    // console.log(connection.destination, connection.destination === target);
    // console.log("-------------------------");

    if (connection.source === node && connection.destination === target) {
      return connection.weight;
    }
  }

  throw new Error("Should not happen");
};

const getNeighbors = (connections, settledNodes, node) => {
  const neighbors = [];

  for (let i = 0; i < connections.length; i++) {
    const edge = connections[i];

    if (edge.source === node && settledNodes.indexOf(edge.destination) === -1) {
      neighbors.push(edge.destination);
    }
  }

  return neighbors;
};

export default class DijkstraPathFinder {
  find(graph, start, target) {
    const distances = Object.keys(graph.nodes).reduce((prev, key) => {
      prev[key] = HIGH;
      return prev;
    }, {});

    const settledNodes = [];
    const unsettledNodes = [];

    unsettledNodes.push(start);
    distances[start.name] = 0;

    const predessecors = [];

    while (unsettledNodes.length > 0) {
      const evalutionNode = getNodesWithLowestDistance(
        unsettledNodes,
        distances
      );

      // Add node to setteld nodes
      settledNodes.push(evalutionNode);

      // Remove from unsettled nodes
      const indexOfNode = unsettledNodes.indexOf(evalutionNode);
      unsettledNodes.splice(indexOfNode, 1);

      // Evalute neighbors
      const adjacentNodes = getNeighbors(
        graph.connections,
        settledNodes,
        evalutionNode
      );

      for (let i = 0; i < adjacentNodes.length; i++) {
        const t = adjacentNodes[i];
        const a = getShortestDistance(t, distances);
        const b =
          getShortestDistance(evalutionNode, distances) +
          getDistance(graph.connections, evalutionNode, t);

        if (a > b) {
          // Save the distance
          distances[t.name] = b;

          // Add a relation to the node
          predessecors[t.name] = evalutionNode;

          // We have not touched this nde
          unsettledNodes.push(t);
        }
      }
    }

    // Is it possible to find a path?
    if (!predessecors.hasOwnProperty(target.name)) {
      throw new Error("Path not found");
    }

    // Go up the predessecors to find the path
    const path = [];

    let step = target;
    while (step) {
      path.push(step);
      step = predessecors[step.name];
    }

    path.reverse();
    return path;
  }
}
