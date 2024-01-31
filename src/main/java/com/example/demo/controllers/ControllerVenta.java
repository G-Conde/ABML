package com.example.demo.controllers;

import com.example.demo.models.Client;
import com.example.demo.models.Producto;
import com.example.demo.models.Venta;
import com.example.demo.repository.Repository;
import com.example.demo.repository.repositoryProducto;
import com.example.demo.repository.repositoryVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

public class ControllerVenta {

    @Autowired
    private Repository repoCliente;

    @Autowired
    private repositoryProducto repoProducto;

    @Autowired
    private repositoryVenta repoVenta;

    @PostMapping("realizarVenta/{clienteId}/{productoId}/{cantidadProductos}")
    public String realizarVenta(@PathVariable Long clienteId, @PathVariable Long productoId,@PathVariable int cantidadProductos) {
        Client cliente = repoCliente.findById(clienteId).orElse(null);
        Producto producto = repoProducto.findById(productoId).orElse(null);

        if (cliente != null && producto != null) {
            Venta venta = new Venta();
            venta.setCliente(cliente);
            venta.setProducto(producto);
            venta.setCantidadProductos(cantidadProductos);
            venta.setFecha(new Date());  // Puedes ajustar la fecha según tus necesidades

            repoVenta.save(venta);
            return "Venta realizada exitosamente";
        } else {
            return "No se pudo realizar la venta. Cliente o producto no encontrado";
        }
    }
}
