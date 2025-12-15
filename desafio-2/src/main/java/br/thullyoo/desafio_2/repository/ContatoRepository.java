package br.thullyoo.desafio_2.repository;

import br.thullyoo.desafio_2.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
