package com.trilhaspringboot.aprendendospringboot.infrastructure.repository;

import com.trilhaspringboot.aprendendospringboot.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
