package com.ce1103.p3.Grafo;

import java.util.*;
/***
 * Node Graph class
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class Node {
    public String name;
    public List<Node> shortestPath = new LinkedList<>();
    public int distance = Integer.MAX_VALUE;
    public Map<Node, Integer> adjacentNodes = new HashMap<>();

    /***
     * set the edge of a vertex
     * @param destination
     * @param distance
     */
    public void addDestination(Node destination, int distance){
        adjacentNodes.put(destination, distance);
    }

    /***
     * Constructor method
     * @param name
     */
    public Node(String name){
        this.name = name;
    }

    /***
     * get name of the node
     * @return
     */
    public String getName() {
        return name;
    }

    /***
     * set name of the node
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * return the shortest path
     * @return
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /***
     * set the shortest path
     * @param shortestPath
     */
    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /***
     * get the distance vertex-vertex
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /***
     * set the distance vertex-vertex
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /***
     * return the adjacent nodes
     * @return
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /***
     * set the adjacent nodes
     * @param adjacentNodes
     */
    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
