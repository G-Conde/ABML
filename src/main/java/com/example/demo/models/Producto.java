package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column
    private String nombre;
    @Column
    private int valor;

}
