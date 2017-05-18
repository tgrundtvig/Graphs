class Connection {
  constructor(source, destination, weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
}

class Node {
  constructor(name) {
    this.name = name;
  }

  connect(node, weight) {
    return new Connection(this, node, weight);
  }
}

export default class Graph {
  nodes = {};
  connections = [];

  addNode(nodeId) {
    const node = new Node(nodeId);
    this.nodes[nodeId] = node;
  }

  addEdge(aNodeId, bNodeId, weight) {
    const connection = this.nodes[aNodeId].connect(this.nodes[bNodeId], weight);
    this.connections.push(connection);

    return connection;
  }
}
