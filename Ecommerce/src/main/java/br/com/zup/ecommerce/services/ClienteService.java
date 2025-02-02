package br.com.zup.ecommerce.services;

import br.com.zup.ecommerce.models.Cliente;
import br.com.zup.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        validateClienteUniqueness(cliente);
        return clienteRepository.save(cliente);
    }

    private void validateClienteUniqueness(Cliente cliente) {
        boolean cpfExists = clienteRepository.existsByCpf(cliente.getCpf());
        boolean emailExists = clienteRepository.existsByEmail(cliente.getEmail());

        if (cpfExists) {
            throw new IllegalArgumentException("Cliente com o mesmo CPF já cadastrado.");
        }

        if (emailExists) {
            throw new IllegalArgumentException("Cliente com o mesmo email já cadastrado.");
        }
    }
}