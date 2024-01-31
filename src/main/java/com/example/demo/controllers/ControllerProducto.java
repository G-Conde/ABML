package com.example.demo.controllers;

import com.example.demo.models.Producto;
import com.example.demo.repository.repositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProducto {

    @Autowired
    private repositoryProducto repo;

    @GetMapping("/productos")
    public String index() {
        return "En linea";
    }

    @GetMapping("Productos")
    public List<Producto> getProductos() {
        return repo.findAll();
    }

    @PostMapping("Alta")
    public String post(@RequestBody Producto producto) {
        repo.save(producto);
        return "Guardado";
    }

    @PutMapping("Modificar/{id}")
    public String update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updateProducto = repo.findById(id).orElse(null);

        if (updateProducto != null) {
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setValor(producto.getValor());
            repo.save(updateProducto);
            return "Se modificó el producto";
        } else {
            return "Producto no encontrado";
        }
    }

    @DeleteMapping("Borrar/{id}")
    public String delete(@PathVariable Long id) {
        Producto deleteProducto = repo.findById(id).orElse(null);

        if (deleteProducto != null) {
            repo.delete(deleteProducto);
            return "Se eliminó el producto";
        } else {
            return "Producto no encontrado";
        }
    }
}

