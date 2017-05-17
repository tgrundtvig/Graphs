import Graph from "../Graph";

const findCycle = (graph, startNode) => {
  if (!graph || !startNode) {
    return null;
  }

  const visitedNodes = [];
  const nodesToVisit = [startNode];

  while (nodesToVisit.length > 0) {
    const node = nodesToVisit.shift();

    //   console.log(`Searching ${node.name}`);

    if (!node.connection) {
      // console.log(`   Node do not have a connection - clearing visitedNodes`);
      visitedNodes.splice(0, visitedNodes.length);

      continue;
    }

    const nextNode = node.connection.destination;
    //   console.log(`   Is ${nextNode.name} in visitedList?`);

    if (visitedNodes.includes(nextNode)) {
      // console.log(`       It was - return entries`);
      return [...visitedNodes, node];
    }

    //   console.log(`       It was NOT. `);
    //   console.log(
    //     `           Adding nextNode to nodesToVisit - ${nodesToVisit.join(",")}`
    //   );
    nodesToVisit.push(nextNode);
    //   console.log(
    //     `           Adding node to visitedNodes - ${visitedNodes.join(",")}`
    //   );
    visitedNodes.push(node);
  }

  return null;
};

export default graph => {
  if (!graph) {
    return null;
  }

  const nodes = Object.values(graph.nodes);

  const cycles = [];

  let allCycleNodes = [];

  for (let i = 0; i < nodes.length; i++) {
    const node = nodes[i];

    if (allCycleNodes.includes(node)) {
      continue;
    }

    const cycle = findCycle(graph, node);
    if (cycle !== null) {
      cycles.push(cycle);
      allCycleNodes = allCycleNodes.concat(cycle);
    }
  }

  if (cycles.length === 0) {
    return null;
  }

  return cycles;
};
