package br.com.zup.Ecommerce.services;

import br.com.zup.Ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getcpf())) {
            throw new IllegalArgumentException("Cliente com o mesmo CPF já cadastrado.");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Cliente com o mesmo email já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }
}
