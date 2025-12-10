package br.thullyoo.desafio_backend_java.services;

import br.thullyoo.desafio_backend_java.dto.AderirEmpresaRequest;
import br.thullyoo.desafio_backend_java.dto.ClientRequest;
import br.thullyoo.desafio_backend_java.dto.TransferenciaRequest;
import br.thullyoo.desafio_backend_java.model.Cliente;
import br.thullyoo.desafio_backend_java.model.Empresa;
import br.thullyoo.desafio_backend_java.repositories.ClienteRepository;
import br.thullyoo.desafio_backend_java.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ClientService {

    public final ClienteRepository clienteRepository;

    public final EmpresaRepository empresaRepository;

    public ClientService(ClienteRepository clienteRepository, EmpresaRepository empresaRepository) {
        this.clienteRepository = clienteRepository;
        this.empresaRepository = empresaRepository;
    }

    public Cliente register(ClientRequest clientRequest){
        Cliente cliente = new Cliente();
        cliente.setCpf(clientRequest.cpf());
        cliente.setNome(clientRequest.nome());
        cliente.setEmail(clientRequest.email());

        String cnpj = clientRequest.empresa_cpnj();

        if (cnpj != null && !cnpj.isBlank()) {
            Optional<Empresa> empresa = empresaRepository.findById(cnpj);
            if (empresa.isEmpty()) {
                throw new RuntimeException("Empresa não encontrada");
            }
            cliente.setEmpresa(empresa.get());
        }

        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente aderirEmpresa(AderirEmpresaRequest aderirEmpresaRequest){
        Optional<Cliente> cliente =  clienteRepository.findByCpf(aderirEmpresaRequest.cpf());
        if (cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
        if (cliente.get().getEmpresa() == null){
            Optional<Empresa> empresa = empresaRepository.findByCnpj(aderirEmpresaRequest.cnpj());
            if (empresa.isEmpty()){
                throw new RuntimeException("Empresa não encontrada");
            }
            cliente.get().setEmpresa(empresa.get());
        }
        clienteRepository.save(cliente.get());
        return cliente.get();
    }

    public Empresa transferir(TransferenciaRequest transferenciaRequest) {
        Optional<Cliente> clienteOpt = clienteRepository.findByCpf(transferenciaRequest.cpf());

        if (clienteOpt.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Cliente cliente = clienteOpt.get();

        if (cliente.getEmpresa() == null) {
            throw new RuntimeException("Cliente não associado a alguma empresa");
        }

        if (transferenciaRequest.valor() == null || transferenciaRequest.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor deve ser maior que zero");
        }

        Empresa empresa = cliente.getEmpresa();

        BigDecimal novoSaldo = empresa.getSaldo().add(transferenciaRequest.valor());
        empresa.setSaldo(novoSaldo);

        return empresaRepository.save(empresa);
    }

}
