package br.thullyoo.desafio_backend_java.controllers;

import br.thullyoo.desafio_backend_java.dto.ClientRequest;
import br.thullyoo.desafio_backend_java.model.Cliente;
import br.thullyoo.desafio_backend_java.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClientService clientService;

    public ClienteController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Cliente> registerCliente(@RequestBody @Valid ClientRequest clientRequest){
        Cliente cliente = clientService.register(clientRequest);

        return ResponseEntity.ok(cliente);
    }

}
