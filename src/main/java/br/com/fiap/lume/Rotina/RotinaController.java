package br.com.fiap.lume.Rotina;

import br.com.fiap.lume.Rotina.dto.RotinaRequest;
import br.com.fiap.lume.Rotina.dto.RotinaResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/rotina")
public class RotinaController {
    @Autowired
    RotinaService service;

    @Autowired
    RotinaRepository repository;

    //Listar todos os dispositivos - Método GETs
    @GetMapping
    @Operation(
            summary = "Listar Rotinas",
            description = "Retorna uma lista das rotinas com paginação."
    )
    public Page<Rotina> index(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return repository.findAll(pageable);
    }
    //Criar uma rotina - Método POST
    @Operation(
            summary = "Cadastra Rotinas",
            description = "Cria as rotinas com paginação."
    )
    @PostMapping
    public ResponseEntity<RotinaResponse> create (@RequestBody RotinaRequest rotinaRequest, UriComponentsBuilder uriBuilder){
        var rotina = service.create(rotinaRequest.toModel());
        var uri = uriBuilder.path("/rotina/{id}")
                .buildAndExpand(rotina.getId())
                .toUri();
        return ResponseEntity.created(uri).body(RotinaResponse.from(rotina));
    }
    //Atualizar uma rotina - Método PUT
    @Operation(
            summary = "Atualizar Rotinas",
            description = "Atualizar as rotinas."
    )
    @PutMapping("/{id}")
    public Rotina update(@PathVariable Long id, @RequestBody Rotina rotina){
        verificarRotinaExiste(id);
        rotina.setId(id);
        return service.update(rotina);
    }
    //Deletar uma rotina - Método DELETE
    @Operation(
            summary = "Deletar Rotinas",
            description = "Deletar as rotinas de dispositivos."
    )
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        verificarRotinaExiste(id);
        repository.deleteById(id);
    }
    //Verificar se a rotina existe
    private void verificarRotinaExiste(Long id){
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Rotina não encontrada"));
    }
}
