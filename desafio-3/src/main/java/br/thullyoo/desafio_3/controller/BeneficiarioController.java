package br.thullyoo.desafio_3.controller;

import br.thullyoo.desafio_3.dto.BeneficiarioRequest;
import br.thullyoo.desafio_3.dto.BeneficiarioResponse;
import br.thullyoo.desafio_3.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @PostMapping
    public ResponseEntity<BeneficiarioResponse> registrar(@RequestBody BeneficiarioRequest beneficiarioRequest){
        return ResponseEntity.ok(beneficiarioService.registrar(beneficiarioRequest));
    }

}
