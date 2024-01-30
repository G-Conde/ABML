package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Repository repo;


    @GetMapping
    public  String index(){
        return "Conectado";
    }

    @GetMapping("clientes")
    public List<Client> getClientes(){
        return  repo.findAll();
    }

    @PostMapping("alta")
    public String post(@RequestBody Client cliente){
        repo.save(cliente);
        return "Guardado";
    }

    @PutMapping("modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Client cliente){
        Client updateCliente = repo.findById(id).get();
        updateCliente.setApellido(cliente.getApellido());
        updateCliente.setDni(cliente.getDni());
        updateCliente.setEdad(cliente.getEdad());
        updateCliente.setEmail(cliente.getEmail());
        updateCliente.setNombre(cliente.getNombre());
        repo.save(updateCliente);
        return "Modificado";
    }

    @DeleteMapping("baja/{id}")
    public String delete(@PathVariable Long id){

        Client deleteCliente = repo.findById(id).get();
        repo.delete(deleteCliente);
        return "Eliminado";
    }



}






