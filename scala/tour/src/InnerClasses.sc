class Graph {
  class Node {
    var connectedNodes: List[Node] = Nil
    def connectTo(node: Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }

  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}

val graph0: Graph = new Graph
val node01: graph0.Node = graph0.newNode
val node02: graph0.Node = graph0.newNode
val node03: graph0.Node = graph0.newNode
graph0.nodes
node01.connectTo(node02)
node03.connectTo(node01)

val graph1: Graph = new Graph
val node11: graph1.Node = graph1.newNode
val node12: graph1.Node = graph1.newNode
node11.connectTo(node12)      // legal
val graph2: Graph = new Graph
val node23: graph2.Node = graph2.newNode
//node11.connectTo(node23)      // illegal!
//Error:(33, 85) type mismatch;
//found   : A$A24.this.graph2.Node
//required: A$A24.this.graph1.Node

class CommunicableGraph {
  class Node {
    var connectedNodes: List[CommunicableGraph#Node] = Nil
    def connectTo(node: CommunicableGraph#Node) {
      if (connectedNodes.find(node.equals).isEmpty) {
        connectedNodes = node :: connectedNodes
      }
    }
  }
  var nodes: List[Node] = Nil
  def newNode: Node = {
    val res = new Node
    nodes = res :: nodes
    res
  }
}