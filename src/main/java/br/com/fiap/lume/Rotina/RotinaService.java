package br.com.fiap.lume.Rotina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotinaService {

    @Autowired
    RotinaRepository repository;

    public List<Rotina> findAll() {
        return repository.findAll();
    }
    public Rotina create(Rotina rotina) {
        return repository.save(rotina);
    }
    public Rotina update(Rotina rotina) {
        return repository.save(rotina);
    }
}
