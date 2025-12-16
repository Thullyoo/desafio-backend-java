package br.thullyoo.desafio_2.service;

import br.thullyoo.desafio_2.dto.ClienteRequest;
import br.thullyoo.desafio_2.dto.ClienteResponse;
import br.thullyoo.desafio_2.dto.ContatoResponse;
import br.thullyoo.desafio_2.model.Cliente;
import br.thullyoo.desafio_2.model.Contato;
import br.thullyoo.desafio_2.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return new ClienteResponse(cliente.getName(), cliente.getEmail(), List.of());
    }

    public List<ClienteResponse> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponse> clienteResponses = new ArrayList<>();
        for (Cliente cliente : clientes){
            List<ContatoResponse> contatoResponses = new ArrayList<>();
            for (Contato contato : cliente.getContatos()){
                contatoResponses.add(new ContatoResponse(contato.getId(),contato.getType(),contato.getValue()));
            }
            clienteResponses.add(new ClienteResponse(cliente.getName(),cliente.getEmail(),contatoResponses));
        }
        return clienteResponses;
    }

    public ClienteResponse getCliente(UUID id){
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new RuntimeException("Cliente não registrado");
        }
        List<ContatoResponse> contatos = new ArrayList<>();
        for (Contato contato : cliente.get().getContatos()){
            contatos.add(new ContatoResponse(contato.getId(),contato.getType(),contato.getValue()));
        }
        return new ClienteResponse(cliente.get().getName(),cliente.get().getEmail(), contatos);
    }
}
