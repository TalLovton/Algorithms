package test;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.LinkedList;

public class WeightedGraph {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int sourceVert, int destinationVert, int weightEdje) {
            this.source = sourceVert;
            this.destination = destinationVert;
            this.weight = weightEdje;
        }

    }

    static class Graph {
        public LinkedList<Edge>[] graph;
        public int Gsize;

        public Graph(int size) {
            int i;
            Gsize = size;
            graph = new LinkedList[Gsize];
            for (i = 0; i < Gsize; i++) {
                graph[i] = new LinkedList<Edge>();
            }
        }

        public void addEgde(int sourceV,int destinatinV,int weightE){
            Edge tmpEgde = new Edge(sourceV,destinatinV,weightE);
            graph[sourceV].addFirst(tmpEgde);
        }

        public void printGraph(int graphSize){
            int i,j;
            for(i =0; i < graphSize; i++){
                for(j =0; j < graph[i].size(); j++){
                    System.out.println("Edge: " + graph[i].get(j).source + "--" + graph[i].get(j).weight + "-->" +
                            graph[i].get(j).destination);
                }
            }
        }

        public Graph primAlgo(int graphSize){
            Graph minTree = new Graph(graphSize);
            LinkedList<Edge> [] copiedGraph = graph.clone();
            Edge tmpEdge = null;
            Edge minEdge = null;
            Random rand = new Random();
            int minWeight = 0,i,j =0,minInd = 0;
            int sourceV =rand.nextInt(graphSize);
            int [] vertexArr = new int[graphSize];

            while(isSpanning(vertexArr) && j < graphSize){
                vertexArr[sourceV] = 1;
                for(i =0; i < graphSize; i++){
                    if(i == 0){
                        tmpEdge = findMinEgde(copiedGraph[sourceV]);
                        minWeight = tmpEdge.weight;
                        minEdge = tmpEdge;
                        minInd = sourceV;
                    }
                    else if(vertexArr[i] == 1){
                        tmpEdge = findMinEgde(copiedGraph[i]);
                        if(minWeight > tmpEdge.weight){
                            minWeight = tmpEdge.weight;
                            minEdge = tmpEdge;
                            minInd = i;
                        }
                    }
                }
                vertexArr[minEdge.destination] = 1;
                minTree.graph[j].add(minEdge);
                copiedGraph = removeEdges(copiedGraph,minEdge,minInd);
                j++;
            }

            return  minTree;
        }



        private boolean isSpanning(int[] arr){
            int i;
            for(i =0; i < arr.length; i++){
                if(arr[i] == 0){
                    return true;
                }
            }
            return false;
        }

        private  Edge findMinEgde(LinkedList<Edge> list){
            int i,minEdgeInd = 0;
            int minWeight = list.get(0).weight;
            for(i =0; i < list.size(); i++){
                if(list.get(i).weight < minWeight){
                    minWeight = list.get(i).weight;
                    minEdgeInd = i;
                }
            }
            return list.get(minEdgeInd);
        }

        private LinkedList<Edge> [] removeEdges(LinkedList<Edge> [] listArr,Edge edge,int ind){
            int i;
            listArr[ind].remove(edge);
            int destInd = edge.destination;
            Edge tmp;
            for(i =0; i < listArr[destInd].size(); i++){
                 tmp = listArr[destInd].get(i);
                if(edge.destination == tmp.source && edge.source == tmp.destination ){
                    listArr[destInd].remove(i);
                }
            }
            return listArr;
        }

        public Graph checkNewEdge(Graph minSpanTree, Edge edge){
            LinkedList<Edge>[] listArr = new LinkedList[Gsize];
            listArr = minSpanTree.graph;
            Edge tmpEdge = null;
            int vInd = edge.source;
            int i,graphEdgesSize = listArr[vInd].size();
            for (i =0; i < graphEdgesSize; i++){
                tmpEdge = listArr[vInd].get(i);
                if(tmpEdge.weight > edge.weight){
                    tmpEdge.source = edge.source;
                    tmpEdge.destination = edge.destination;
                    tmpEdge.weight = edge.weight;
                    System.out.println("Minimum Spaning Tree has CHANGED!");
                }
                else{
                    System.out.println("Minimum Spaning Tree has remain the SAME!");
                }
            }
            return minSpanTree;
        }

        public Graph createNewGraph(int Q3Size){
           Graph Q3Graph = new Graph(Q3Size);
           Edge newEdge = null;
           Random rand = new Random();
           int i,j,numOfEdges = 0,tmpWeight =0;
           int tmpDestination = 0;
           for(i=0; i < Q3Size; i++){
               numOfEdges = rand.nextInt(Q3Size);
               for(j =0; j < numOfEdges; j++){
                   tmpWeight = rand.nextInt(Q3Size);
                   tmpDestination = rand.nextInt(Q3Size);
                   newEdge = new Edge(i,(tmpDestination),tmpWeight);
                   Q3Graph.graph[i].add(j,newEdge);
               }
           }

           return Q3Graph;
        }

    }
}
