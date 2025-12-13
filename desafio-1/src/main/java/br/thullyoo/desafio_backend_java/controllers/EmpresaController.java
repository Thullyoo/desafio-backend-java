package br.thullyoo.desafio_backend_java.controllers;

import br.thullyoo.desafio_backend_java.dto.EmpresaRequest;
import br.thullyoo.desafio_backend_java.model.Empresa;
import br.thullyoo.desafio_backend_java.services.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> registerEmpresa(@RequestBody @Valid EmpresaRequest empresaRequest){
        Empresa empresa = empresaService.register(empresaRequest);
        return ResponseEntity.ok(empresa);
    }

}
