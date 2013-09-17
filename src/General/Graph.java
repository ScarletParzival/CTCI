package General;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/15/13
 * Time: 7:41 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Graph {

    static class GraphNode {
        public final String name;
        public final HashSet<Edge> inEdges;
        public final HashSet<Edge> outEdges;
        public GraphNode(String name) {
            this.name = name;
            inEdges = new HashSet<Edge>();
            outEdges = new HashSet<Edge>();
        }
        public GraphNode addEdge(GraphNode graphNode){
            Edge e = new Edge(this, graphNode);
            outEdges.add(e);
            graphNode.inEdges.add(e);
            return this;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    static class Edge{
        public final GraphNode from;
        public final GraphNode to;
        public Edge(GraphNode from, GraphNode to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object obj) {
            Edge e = (Edge)obj;
            return e.from == from && e.to == to;
        }
    }

    public static void main(String[] args) {

        GraphNode seven = new GraphNode("7");
        GraphNode five = new GraphNode("5");
        GraphNode three = new GraphNode("3");
        GraphNode eleven = new GraphNode("11");
        GraphNode eight = new GraphNode("8");
        GraphNode two = new GraphNode("2");
        GraphNode nine = new GraphNode("9");
        GraphNode ten = new GraphNode("10");

        seven.addEdge(eleven).addEdge(eight);
        five.addEdge(eleven);
        three.addEdge(eight).addEdge(ten);
        eleven.addEdge(two).addEdge(nine).addEdge(ten);
        eight.addEdge(nine).addEdge(ten);

        GraphNode[] allGraphNodes = {seven, five, three, eleven, eight, two, nine, ten};

        //topologicallySortedList <- Empty list that will contain the sorted elements
        ArrayList<GraphNode> topologicallySortedList = new ArrayList<GraphNode>();

        //graphNodeSetWithNoIncomingEdges <- Set of all nodes with no incoming edges
        HashSet<GraphNode> graphNodeSetWithNoIncomingEdges = new HashSet<GraphNode>();

        for(GraphNode n : allGraphNodes){
            if(n.inEdges.size() == 0){
                System.out.println("Adding "+n+" to graphNodeSetWithNoIncomingEdges");
                graphNodeSetWithNoIncomingEdges.add(n);
            }
        }

        //while graphNodeSetWithNoIncomingEdges is non-empty do
        while(!graphNodeSetWithNoIncomingEdges.isEmpty()){
            //remove a node currentNode from graphNodeSetWithNoIncomingEdges
            GraphNode currentNode = graphNodeSetWithNoIncomingEdges.iterator().next();
            graphNodeSetWithNoIncomingEdges.remove(currentNode);

            //insert currentNode into L
            topologicallySortedList.add(currentNode);

            //for each node m with an edge e from currentNode to m do
            for(Iterator<Edge> removeCurrentNodeEdges = currentNode.outEdges.iterator(); removeCurrentNodeEdges.hasNext(); ){
                //remove edge e from the graph
                Edge e = removeCurrentNodeEdges.next();
                GraphNode toNodeFromCurrentNode = e.to;
                removeCurrentNodeEdges.remove();//Remove edge from currentNode
                toNodeFromCurrentNode.inEdges.remove(e);//Remove edge from toNodeFromCurrentNode

                //if toNodeFromCurrentNode has no other incoming edges then insert toNodeFromCurrentNode into graphNodeSetWithNoIncomingEdges
                if(toNodeFromCurrentNode.inEdges.isEmpty()){
                    graphNodeSetWithNoIncomingEdges.add(toNodeFromCurrentNode);
                }
            }
        }

        //Check to see if all edges are removed
        boolean cycle = false;
        for(GraphNode n : allGraphNodes){
            if(!n.inEdges.isEmpty()){
                cycle = true;
                break;
            }
        }
        if(cycle){
            System.out.println("Cycle present, topological sort not possible");
        }else{
            System.out.println("Topological Sort: "+Arrays.toString(topologicallySortedList.toArray()));
        }
    }
}
