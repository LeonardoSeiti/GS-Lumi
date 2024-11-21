package br.com.fiap.lume.Dispositivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {
    @Autowired
    DispositivoRepository repository;

    public List<Dispositivo> findAll() {
        return repository.findAll();
    }

    public Dispositivo create(Dispositivo dispositivo) {
        return repository.save(dispositivo);
    }

    public Dispositivo update(Dispositivo dispositivo) {
        return repository.save(dispositivo);
    }
}