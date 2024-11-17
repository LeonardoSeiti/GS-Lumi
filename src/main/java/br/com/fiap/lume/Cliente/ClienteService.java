package br.com.fiap.lume.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
}
