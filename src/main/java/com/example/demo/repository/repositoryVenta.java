package com.example.demo.repository;

import com.example.demo.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryVenta extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteId(Long clienteId);
    List<Venta> findByProductoId(Long productoId);

}
