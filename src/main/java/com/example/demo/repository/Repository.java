package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Client;

public interface Repository extends JpaRepository<Client, Long> {
}
