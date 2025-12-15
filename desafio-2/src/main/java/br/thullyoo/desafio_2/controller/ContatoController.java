package br.thullyoo.desafio_2.controller;

import br.thullyoo.desafio_2.dto.ContatoRequest;
import br.thullyoo.desafio_2.dto.ContatoResponse;
import br.thullyoo.desafio_2.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @PostMapping
    public ResponseEntity<ContatoResponse> register(@RequestBody ContatoRequest contatoRequest){
        return ResponseEntity.ok(contatoService.register(contatoRequest));
    }
}
