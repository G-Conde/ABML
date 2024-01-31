package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column
    private int cantidadProductos; //  campo para la cantidad de productos

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;


}
