package com.ce1103.p3.Grafo;

public class Main {

    public static void main(String args[]){

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.addDestination(b,10);
        a.addDestination(c,15);

        b.addDestination(d,12);
        b.addDestination(f,15);

        c.addDestination(e,10);

        d.addDestination(e,2);
        d.addDestination(f,1);

        f.addDestination(e,5);

        Graph graph = new Graph();

        System.out.println(graph);

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        System.out.println(graph);

        Dijkstra dijkstra = new Dijkstra();

        graph = dijkstra.calcShortestPath(graph, b);

        System.out.println(graph);
    }
}
