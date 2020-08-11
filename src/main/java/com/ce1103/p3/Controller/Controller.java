package com.ce1103.p3.Controller;


import com.ce1103.p3.Grafo.Graph;
import com.ce1103.p3.Grafo.Node;
import com.ce1103.p3.Grafo.Ruta;
import com.ce1103.p3.Usuario.CreateJsonTicket;
import com.ce1103.p3.Usuario.Tiquete;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;



@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class Controller {
    CreateJsonTicket tiquetes = new CreateJsonTicket();
    static Graph graph = new Graph();
    @PostMapping("/newUser")
    public void newUsuario(@RequestBody Tiquete tiquete){
        Tiquete tiquete1 = new Tiquete();
        tiquete1.setEmail(tiquete.getEmail());
        System.out.println(tiquete.getEmail());
        System.out.println(tiquete1.getEmail());

        tiquete1.setName(tiquete.getName());

    }
    @PostMapping("/addRoute")
    public void addRoute(@RequestBody Ruta ruta){
        Node temp = new Node(ruta.getName());
        Node c = new Node("Cartago");
        c.addDestination(temp,10);
        temp.addDestination(graph.getNode(ruta.getA()),Integer.parseInt(ruta.getPeso()));
        graph.addNode(temp);
        graph.addNode(c);

        System.out.println(graph);
    }
/*
    @GetMapping("/getUsers")
    public LinkedList<Tiquete> getUsers() {

    }*/

    @PostMapping("/login")
    public void iniciarSesion(@RequestBody Tiquete tiquete){

    }

    @PostMapping("/ticket")
    public void newTicket(@RequestBody Tiquete tiquete){
        try {
            tiquetes.ticketUsuario(tiquete);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
