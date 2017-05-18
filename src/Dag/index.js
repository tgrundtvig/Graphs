import Graph from "../Graph";

import detectCycle from "../CycleDetection";

const getTopologicallyOrder = (graph, startNode) => {
  if (!graph || !startNode) {
    return null;
  }

  // If the graph have a cycle it is not a valid DAG anymore
  if (detectCycle(graph, startNode)) {
    return null;
  }

  // Ley gets all the node connections
  const nodes = [];

  let node = startNode;
  while (node) {
    // Add nodes to list
    nodes.push(node);

    // If the node do not have any connections, then we are done
    if (!node.connection) {
      break;
    }
    
    node = node.connection.destination;
  }

  return nodes;
};

export default getTopologicallyOrder;
