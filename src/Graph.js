class Connection {
  constructor(source, destination, weight) {
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
}

class Node {
  connection = null;

  constructor(name) {
    this.name = name;
  }

  connect(node) {
    this.connection = new Connection(this, node, 1);

    return this.connection;
  }
}

export default class Graph {
  nodes = {};
  connections = [];


  addNode(nodeId) {
    const node = new Node(nodeId);
    this.nodes[nodeId] = node;
  }

  addEdge(aNodeId, bNodeId) {
    const connection = this.nodes[aNodeId].connect(this.nodes[bNodeId]);
    this.connections.push(connection);
  }
}
