package br.thullyoo.desafio_2.repository;

import br.thullyoo.desafio_2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
