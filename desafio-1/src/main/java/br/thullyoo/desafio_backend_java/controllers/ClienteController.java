package br.thullyoo.desafio_backend_java.controllers;

import br.thullyoo.desafio_backend_java.dto.AderirEmpresaRequest;
import br.thullyoo.desafio_backend_java.dto.ClientRequest;
import br.thullyoo.desafio_backend_java.dto.SaqueRequest;
import br.thullyoo.desafio_backend_java.dto.TransferenciaRequest;
import br.thullyoo.desafio_backend_java.model.Cliente;
import br.thullyoo.desafio_backend_java.model.Empresa;
import br.thullyoo.desafio_backend_java.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/aderirEmpresa")
    public ResponseEntity<Cliente> aderirEmpresa(@RequestBody @Valid AderirEmpresaRequest aderirEmpresaRequest){
        Cliente cliente =  clientService.aderirEmpresa(aderirEmpresaRequest);

        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/transferir")
    public ResponseEntity<Empresa> transferir(@RequestBody @Valid TransferenciaRequest transferenciaRequest){
        Empresa empresa =  clientService.depositar(transferenciaRequest);

        return ResponseEntity.ok(empresa);
    }

    @PostMapping("/sacar")
    public ResponseEntity<Empresa> sacar(@RequestBody @Valid SaqueRequest saqueRequest){
        Empresa empresa =  clientService.sacar(saqueRequest);

        return ResponseEntity.ok(empresa);
    }
}
