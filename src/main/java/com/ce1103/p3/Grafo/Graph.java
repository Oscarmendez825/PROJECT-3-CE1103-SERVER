package com.ce1103.p3.Grafo;

import java.util.HashSet;
import java.util.Set;

/***
 * Graph  class
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Graph {
    public Set<Node> nodes = new HashSet<>();

    /***
     * Override toString method to print the graph in console
     * @return
     */
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

    /***
     * add node into the graph
     * @param nodeA
     */
    public void addNode(Node nodeA){
        nodes.add(nodeA);
    }

    /***
     * get nodes method
     * @return
     */
    public Set<Node> getNodes() {
        return nodes;
    }

    /***
     * set nodes method
     * @param nodes
     */
    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    /***
     * get Node Method
     * @param name
     * @return
     */
    public Node getNode(String name){
        for (Node node : this.nodes) {
            if (name.equals(node.getName())){
                return node;

            }

            }
        return null;
    }





}
