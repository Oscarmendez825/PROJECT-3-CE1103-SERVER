package com.ce1103.p3.Grafo;

import java.util.*;


public class Dijkstra {
    public Graph calcShortestPath(Graph graph, Node source){
        source.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node current = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(current);
            for(Map.Entry<Node, Integer> adjacencyPair : current.getAdjacentNodes().entrySet()){
                Node adjacentNode = adjacencyPair.getKey();
                int edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)){
                    calcMinDistance(adjacentNode, edgeWeight, current);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(current);
        }
        return graph;
    }

    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes){
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance){
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calcMinDistance(Node evalNode, int weight, Node source){
        int sourceDistance = source.getDistance();
        if (sourceDistance + weight < evalNode.getDistance()){
            evalNode.setDistance(sourceDistance + weight);
            LinkedList<Node> shortestPath = new LinkedList<Node>(source.getShortestPath());
            shortestPath.add(source);
            evalNode.setShortestPath(shortestPath);
        }
    }
}
