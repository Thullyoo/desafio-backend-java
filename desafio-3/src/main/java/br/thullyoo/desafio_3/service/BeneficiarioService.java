package br.thullyoo.desafio_3.service;

import br.thullyoo.desafio_3.dto.BeneficiarioRequest;
import br.thullyoo.desafio_3.dto.BeneficiarioResponse;
import br.thullyoo.desafio_3.dto.DocumentoRequest;
import br.thullyoo.desafio_3.dto.DocumentoResponse;
import br.thullyoo.desafio_3.model.Beneficiario;
import br.thullyoo.desafio_3.model.Documento;
import br.thullyoo.desafio_3.repositories.BeneficiarioRepository;
import br.thullyoo.desafio_3.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    public BeneficiarioResponse registrar(BeneficiarioRequest request){
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(request.nome());
        beneficiario.setDataNascimento(request.dataNascimento());
        beneficiario.setTelefone(request.telefone());
        beneficiario.setDataAtualizacao(LocalDateTime.now());
        beneficiario.setDataInclusao(LocalDateTime.now());
        List<DocumentoResponse> documentoResponseList = new ArrayList<>();

        beneficiario = beneficiarioRepository.save(beneficiario);

        for (DocumentoRequest documentoRequest : request.documentos()){
            Documento documento = new Documento();
            documento.setDataAtualizacao(LocalDateTime.now());
            documento.setTipoDocumento(documentoRequest.tipoDocumento());
            documento.setDataInclusao(LocalDateTime.now());
            documento.setDescricao(documentoRequest.descricao());
            documento.setBeneficiario(beneficiario);
            documento = documentoRepository.save(documento);

            documentoResponseList.add(new DocumentoResponse(documento.getId(), documento.getTipoDocumento(), documento.getDescricao(), documento.getDataInclusao(), documento.getDataAtualizacao()));
        }

        return new BeneficiarioResponse(beneficiario.getId(), beneficiario.getNome(), beneficiario.getTelefone(), beneficiario.getDataNascimento(), beneficiario.getDataInclusao(), beneficiario.getDataAtualizacao(), documentoResponseList);
    }
}
