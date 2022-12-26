package test;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

//Students names: Tal Lovton, Eva Karkar
//Student ID : 208710137,212251383

public class Main {
    private static final int GRAPH_SIZE = 5;
    private static final int Q3_GRAPH_SIZE = 21;
    public static void main(String[] args){
//      --------Q1----------------------------------------------------
        WeightedGraph.Graph graph = new WeightedGraph.Graph(GRAPH_SIZE);
        WeightedGraph.Graph minSpanningTree = new WeightedGraph.Graph(GRAPH_SIZE);
        graph.addEgde(0,4,5);
        graph.addEgde(0,1,3);
        graph.addEgde(1,4,7);
        graph.addEgde(1,3,1);
        graph.addEgde(1,2,4);
        graph.addEgde(1,0,3);
        graph.addEgde(2,3,8);
        graph.addEgde(2,1,4);
        graph.addEgde(3,4,2);
        graph.addEgde(3,2,8);
        graph.addEgde(3,1,1);
        graph.addEgde(4,3,2);
        graph.addEgde(4,1,7);
        graph.addEgde(4,0,5);


        minSpanningTree = graph.primAlgo(GRAPH_SIZE);
        System.out.println("---------Q1 minimum spaning tree after Prim alg---------\n");
        minSpanningTree.printGraph(GRAPH_SIZE);
//      --------Q2----------------------------------------------------
        WeightedGraph.Edge newEdge = new WeightedGraph.Edge(0,3,2);
        minSpanningTree = graph.checkNewEdge(minSpanningTree,newEdge);
        minSpanningTree.printGraph(GRAPH_SIZE);
//      --------Q3----------------------------------------------------
        WeightedGraph.Graph Q3Graph = new WeightedGraph.Graph(Q3_GRAPH_SIZE);
        Q3Graph = Q3Graph.createNewGraph(Q3_GRAPH_SIZE);
        System.out.println("---------Q3 Graph before Prim alg---------\n");
        Q3Graph.printGraph(Q3_GRAPH_SIZE);
        minSpanningTree = Q3Graph.primAlgo(Q3_GRAPH_SIZE);
        System.out.println("---------Q3 minimum spaning tree after Prim alg---------\n");
        minSpanningTree.printGraph(Q3_GRAPH_SIZE);
        System.out.println("---------Q3 creating new Edge---------\n");
        WeightedGraph.Edge newQ3Edge = new WeightedGraph.Edge(3,10,22);
        System.out.println("Edge: " + newQ3Edge.source + "--" + newQ3Edge.weight + "-->" +
                newQ3Edge.destination);
        System.out.println("---------Q3 creating new Edge and editing the Tree---------\n");
        WeightedGraph.Edge newQ3Edge1 = new WeightedGraph.Edge(1,15,0);
        minSpanningTree = graph.checkNewEdge(minSpanningTree,newQ3Edge1);
        minSpanningTree.printGraph(Q3_GRAPH_SIZE);
    }
}


