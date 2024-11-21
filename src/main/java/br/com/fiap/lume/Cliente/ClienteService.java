package br.com.fiap.lume.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;
    //Find all - Busca por todos os clientes
    public List<Cliente> findAll() {
        return repository.findAll();
    }
    //Create cliente
    public Cliente create(Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        return repository.save(cliente);
    }
    public Cliente update (Cliente cliente){
        cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
        return repository.save(cliente);
    }    
}