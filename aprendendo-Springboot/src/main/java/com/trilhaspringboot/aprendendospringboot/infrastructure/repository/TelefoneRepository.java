package com.trilhaspringboot.aprendendospringboot.infrastructure.repository;

import com.trilhaspringboot.aprendendospringboot.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
