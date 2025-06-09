package it.diyar.justeatremap.services;

import it.diyar.justeatremap.models.Cliente;
import it.diyar.justeatremap.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getById(String codiceFiscale) {
        return clienteRepository.findById(Long.valueOf(codiceFiscale));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(String codiceFiscale) {
        clienteRepository.deleteById(Long.valueOf(codiceFiscale));
    }
}
