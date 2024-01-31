package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Producto;


public interface repositoryProducto extends JpaRepository<Producto, Long> {

}
