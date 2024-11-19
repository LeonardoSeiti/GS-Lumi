package br.com.fiap.lume.Cliente;

import br.com.fiap.lume.Cliente.dto.ClienteRequest;
import br.com.fiap.lume.Cliente.dto.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {
    @Autowired
    ClienteService service;
    @Autowired
    ClienteRepository repository;
    //Listar todos os clientes - Método GET
    @GetMapping
    @Operation(
            summary = "Listar Clientes",
            description = "Retorna uma lista dos cliente com paginação."
    )
    public Page<Cliente> index( @PageableDefault(size = 5, page = 0) Pageable pageable) {
        return repository.findAll(pageable);
    }
    //Cadastro de cliente - Método POST
    @PostMapping
    public ResponseEntity<ClienteResponse> create(@RequestBody ClienteRequest clienteRequest, UriComponentsBuilder uriBuilder) {
        var cliente = service.create(clienteRequest.toModel());
        var uri = uriBuilder.path("/cliente/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(ClienteResponse.from(cliente));
    }

    //Atualizar dados do cliente - Método PUT
    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        verificarClienteExistente(id);
        cliente.setId(id);
        return service.update(cliente);
    }

    //Deletar cliente - Método DELETE
    @DeleteMapping("/{id}")
    public void destroy(@PathVariable Long id) {
        verificarClienteExistente(id);
        repository.deleteById(id);
    }

    //Verificar se o cliente existe
    private void verificarClienteExistente(Long id){
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Cliente não encontrado"
                ));
    }
}
