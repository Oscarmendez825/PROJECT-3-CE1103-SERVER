package com.ce1103.p3.Controller;


import com.ce1103.p3.Usuario.CreateJsonTicket;
import com.ce1103.p3.Usuario.Tiquete;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedList;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class Controller {
    CreateJsonTicket tiquetes = new CreateJsonTicket();

    @PostMapping("/newUser")
    public void newUsuario(@RequestBody Tiquete tiquete){
        Tiquete tiquete1 = new Tiquete();
        tiquete1.setEmail(tiquete.getEmail());
        System.out.println(tiquete.getEmail());
        System.out.println(tiquete1.getEmail());

        tiquete1.setName(tiquete.getName());


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
