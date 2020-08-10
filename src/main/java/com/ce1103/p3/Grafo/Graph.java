package com.ce1103.p3.Grafo;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    @Override
    public String toString(){
        String graphString = "+++++++Graph+++++++\n";
        for (Node node : this.nodes){
            for (Node path : node.getShortestPath()){
                graphString += path.getName() + " >>> ";
            }
            graphString += node.getName() + "| d = " + node.getDistance() + "\n";
        }
        graphString += "+++++++++++++++++++";
        return graphString;
    }

    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
