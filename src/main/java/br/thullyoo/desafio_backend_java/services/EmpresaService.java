package br.thullyoo.desafio_backend_java.services;

import br.thullyoo.desafio_backend_java.dto.EmpresaRequest;
import br.thullyoo.desafio_backend_java.model.Empresa;
import br.thullyoo.desafio_backend_java.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa register(EmpresaRequest empresaRequest){

        Empresa empresa =  new Empresa();
        empresa.setCnpj(empresaRequest.cnpj());
        empresa.setNome(empresaRequest.nome());
        empresa.setTaxa(empresaRequest.taxa());
        empresa.setSaldo(new BigDecimal(0));
        empresaRepository.save(empresa);

        return empresa;
    }

}
