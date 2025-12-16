package br.thullyoo.desafio_2.controller;

import br.thullyoo.desafio_2.dto.ClienteRequest;
import br.thullyoo.desafio_2.dto.ClienteResponse;
import br.thullyoo.desafio_2.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> register(@RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.ok(clienteService.register(clienteRequest));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> getAll(){
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<ClienteResponse> getCliente(@PathVariable("id") UUID id){
        return ResponseEntity.ok(clienteService.getCliente(id));
    }
}
