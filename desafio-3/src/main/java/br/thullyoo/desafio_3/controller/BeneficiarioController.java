package br.thullyoo.desafio_3.controller;

import br.thullyoo.desafio_3.dto.BeneficiarioListResponse;
import br.thullyoo.desafio_3.dto.BeneficiarioRequest;
import br.thullyoo.desafio_3.dto.BeneficiarioResponse;
import br.thullyoo.desafio_3.dto.DocumentoResponse;
import br.thullyoo.desafio_3.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @PostMapping
    public ResponseEntity<BeneficiarioResponse> registrar(@RequestBody BeneficiarioRequest beneficiarioRequest){
        return ResponseEntity.ok(beneficiarioService.registrar(beneficiarioRequest));
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioListResponse>> listar(){
        return ResponseEntity.ok(beneficiarioService.listar());
    }

    @GetMapping("/{beneficiarioId}")
    public ResponseEntity<List<DocumentoResponse>> listarDocumentos(@PathVariable("beneficiarioId")UUID beneficiarioId){
        return ResponseEntity.ok(beneficiarioService.listarDocumetosPorId(beneficiarioId));
    }

    @PutMapping("/{beneficiarioId}")
    public ResponseEntity<BeneficiarioListResponse> atualizar(@PathVariable("beneficiarioId")UUID beneficiarioId, @RequestBody BeneficiarioRequest beneficiarioRequest){
        return ResponseEntity.ok(beneficiarioService.atualizar(beneficiarioId, beneficiarioRequest));
    }
}
