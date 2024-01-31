package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity //lo que hace al objeto
@Getter
@Setter
public class Client {
    @Id //lo que va a tomar la interface
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column

    private String nombre;
    @Column

    private String apellido;
    @Column

    private int edad;
    @Column

    private String email;

    @Column
    private int dni;


}
