package br.thullyoo.desafio_backend_java.repositories;

import br.thullyoo.desafio_backend_java.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByCpf(String cpf);

}
