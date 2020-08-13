package com.ce1103.p3.Controller;


import com.ce1103.p3.Grafo.*;
import com.ce1103.p3.ListaEnlazadaSimple.ListaEnlazada;
import com.ce1103.p3.Usuario.CreateJsonTicket;
import com.ce1103.p3.Usuario.Precio;
import com.ce1103.p3.Usuario.Tiquete;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/***
 * Controller class
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class Controller {
    CreateJsonTicket tiquetes = new CreateJsonTicket();
    static Graph graph = new Graph();
    static boolean cargado = false;
    ListaEnlazada<Ruta> lista = new ListaEnlazada<Ruta>();
    ListaEnlazada<Node> nodos = new ListaEnlazada<Node>();
    static Precio precioTotal = new Precio();
    WriteGraph wg = new WriteGraph();

    /***
     * add a new user
     * @param tiquete
     */
    @PostMapping("/newUser")
    public void newUsuario(@RequestBody Tiquete tiquete){
        Tiquete tiquete1 = new Tiquete();
        tiquete1.setEmail(tiquete.getEmail());
        System.out.println(tiquete.getEmail());
        System.out.println(tiquete1.getEmail());

        tiquete1.setName(tiquete.getName());

    }

    /***
     * add a new route
     * @param ruta
     */
    @PostMapping("/addRoute")
    public void addRoute(@RequestBody Ruta ruta){
        Node temp = new Node(ruta.getName());
        Node c = new Node("Cartago");
        c.addDestination(temp,10);
        temp.addDestination(graph.getNode(ruta.getA()),Integer.parseInt(ruta.getPeso()));
        graph.addNode(temp);
        graph.addNode(c);
        try {
            wg.addRoute(ruta);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(graph);
    }

    /***
     * charge the graph in to the server
     */
    @PostMapping("cargarGraph")
    public void cargarGrafo(){
        if (cargado == false) {
            JSONParser parser = new JSONParser();
            try {
                JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\RSSERVER\\Graph.json"));
                for (Object o : a) {
                    Ruta ruta = new Ruta();
                    JSONObject obj = (JSONObject) o;
                    String name = (String) obj.get("name");
                    ruta.setName(name);
                    String da = (String) obj.get("a");
                    ruta.setA(da);
                    String peso = (String) obj.get("peso");
                    ruta.setPeso(peso);
                    lista.add(ruta);

                }
                for(int i = 0;i<lista.getSize();i++){
                    boolean valor = false;
                    Node temp = new Node(lista.get(i).getName());
                    for(int j=0;j<nodos.getSize();j++){
                        if (nodos.get(j).getName().equals(temp.getName())){
                           valor = true;
                        }

                    }
                    if (valor == true){

                    }else{
                        nodos.add(temp);

                    }

                }for (int k = 0;k<nodos.getSize();k++){
                    for(int i = 0;i<lista.getSize();i++){
                        Node temp = new Node("");
                        for(int j = 0; j < nodos.getSize();j++){
                            if (nodos.get(j).getName().equals(lista.get(i).getA())){
                                temp = nodos.get(j);
                            }else{
                            }
                        }
                    nodos.get(k).addDestination(temp,Integer.parseInt(lista.get(i).getPeso()));
                }
                }
                for(int i = 0;i<nodos.getSize();i++){
                    graph.addNode(nodos.get(i));
                }
                System.out.println(graph);

                cargado = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{

        }
    }

    /***
     * return the sell tickets history
     * @return
     */
    @GetMapping("/getRegister")
    public JSONArray getRegistro() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\RSSERVER\\JSONuser.json"));
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    /***
     * add new ticket
     * @param tiquete
     */
    @PostMapping("/ticket")
    public void newTicket(@RequestBody Tiquete tiquete){
        try {
            tiquetes.ticketUsuario(tiquete);
            precioTotal.setName(tiquete.getName());
            precioTotal.setApellido(tiquete.getApellido());
            precioTotal.setA(tiquete.getA());
            precioTotal.setDe(tiquete.getDe());
            precioTotal.setCantidad(tiquete.getCantidad());
            precioTotal.setEmail(tiquete.getEmail());
            precioTotal.setPrecio(calculatePrice(graph,graph.getNode(tiquete.getDe()),graph.getNode(tiquete.getA()),Integer.parseInt(tiquete.getCantidad())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /***
     * return the graph
     * @return
     */
    @GetMapping("/getGraph")
    public JSONArray getGraph() {
        System.out.println("grafo");
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\Oscar\\IdeaProjects\\RSSERVER\\Graph.json"));
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /***
     * return the price of the tickets
     * @return
     */
    @GetMapping("/getPrecio")
    public Precio getTotal(){
        return precioTotal;
    }
    public static int calculatePrice(Graph graph,Node from, Node to, int tiquets){
        Graph temp = new Graph();
        temp = graph;
        Dijkstra dijkstra = new Dijkstra();
        temp = dijkstra.calcShortestPath(temp,from);
        int distance = 0;
        int price = 0;
        for(Node node : graph.nodes){
            if (node.distance==Integer.MAX_VALUE){
                continue;
            }
            if(node.name == to.name){
                distance = node.distance;
                break;
            }
        }
        price = (distance * 25)*tiquets;

        int discount = calculateDiscount(tiquets);
        if(discount!=0) {
            price = price - (price*discount/100);
            return price;
        }
        return price;
    }

    /***
     * delete vertex into the graph
     * @param valor
     */
    @PostMapping("/delete")
    public void eliminarRuta(@RequestBody String valor){
        delete(graph,graph.getNode(valor));
    }
    public static int calculateDiscount(int tiquets){

        if(tiquets<=1){
            return 0;
        }else if(tiquets>=45){
            return 90;
        }else {
            int discount;
            discount = (tiquets) * 2;
            return discount;
        }
    }

    /***
     * delete vertex in to the graph
     * @param graph
     * @param nodo
     */
    public void delete(Graph graph, Node nodo){
        graph.nodes.remove(nodo);
        for(Node node: graph.nodes){
            node.adjacentNodes.remove(nodo);
        }
    }

}
