package br.com.fiap.lume.Cliente;

import br.com.fiap.lume.Cliente.dto.ClienteRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {
    @Autowired
    ClienteService service;
    @Autowired
    ClienteRepository repository;

    @GetMapping
    @Operation(
            summary = "Listar Clientes",
            description = "Retorna uma lista dos cliente com paginação."
    )
    public Page<Cliente> index( @PageableDefault(size = 5, page = 0) Pageable pageable) {
        return repository.findAll(pageable);
    }

}
