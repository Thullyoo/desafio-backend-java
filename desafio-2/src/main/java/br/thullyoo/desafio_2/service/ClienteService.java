package br.thullyoo.desafio_2.service;

import br.thullyoo.desafio_2.dto.ClienteRequest;
import br.thullyoo.desafio_2.dto.ClienteResponse;
import br.thullyoo.desafio_2.model.Cliente;
import br.thullyoo.desafio_2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse register(ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        cliente.setName(clienteRequest.name());
        cliente.setEmail(clienteRequest.email());
        cliente.setContatos(List.of());
        clienteRepository.save(cliente);
        return new ClienteResponse(cliente.getName(), cliente.getEmail());
    }

}
