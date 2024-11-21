package br.com.fiap.lume.Dispositivo;

import br.com.fiap.lume.Dispositivo.dto.DispositivoRequest;
import br.com.fiap.lume.Dispositivo.dto.DispositivoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {
    @Autowired
    DispositivoService service;

    @Autowired
    DispositivoRepository repository;
    //Listar todos os dispositivos - Método GETs
    @GetMapping
    @Operation(
            summary = "Listar Dispositivos",
            description = "Retorna uma lista dos dispositivos com paginação."
    )
    public Page<Dispositivo> index(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return repository.findAll(pageable);
    }
    //Cadastro de dispositivo - Método POST
    @Operation(
            summary = "Criação de dispositivo",
            description = "Criação de dispositivos de clientes."
    )
    @PostMapping
    public ResponseEntity<DispositivoResponse> create(@RequestBody DispositivoRequest dispositivoRequest, UriComponentsBuilder uriBuilder) {
        var dispositivo = service.create(dispositivoRequest.toModel());
        var uri = uriBuilder.path("/cliente/{id}")
                .buildAndExpand(dispositivo.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(DispositivoResponse.from(dispositivo));
    }
    //Atualização de dispositivo - Método PUT
    @Operation(
            summary = "Atualizar de dispositivo",
            description = "Atualizar de dispositivos de clientes."
    )
    @PutMapping("/{id}")
    public Dispositivo update(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        virificarDispositivoExistente(id);
        dispositivo.setId(id);
        return service.update(dispositivo);
    }
    //Deletar dispositivo - Método DELETE
    @Operation(
            summary = "Deletar dispositivo",
            description = "Deletar dispositivo de um cliente."
    )
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        virificarDispositivoExistente(id);
        repository.deleteById(id);
    }
    //Método para verificar se o dispositivo existe
    private void virificarDispositivoExistente(Long id){
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Dispositivo não encontrado"
                ));
    }
}
