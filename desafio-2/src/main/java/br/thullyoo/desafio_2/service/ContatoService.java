package br.thullyoo.desafio_2.service;

import br.thullyoo.desafio_2.dto.ContatoRequest;
import br.thullyoo.desafio_2.dto.ContatoResponse;
import br.thullyoo.desafio_2.model.Cliente;
import br.thullyoo.desafio_2.model.Contato;
import br.thullyoo.desafio_2.repository.ClienteRepository;
import br.thullyoo.desafio_2.repository.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    private final ClienteRepository clienteRepository;
    private final ContatoRepository contatoRepository;

    public ContatoService(ClienteRepository clienteRepository, ContatoRepository contatoRepository) {
        this.clienteRepository = clienteRepository;
        this.contatoRepository = contatoRepository;
    }

    public ContatoResponse register(ContatoRequest request) {

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Contato contato = new Contato();
        contato.setType(request.type());
        contato.setValue(request.value());
        contato.setCliente(cliente);

        Contato contatoRes = contatoRepository.save(contato);

        return new ContatoResponse(
                contatoRes.getId(),
                contatoRes.getType(),
                contatoRes.getValue()
        );
    }
}
