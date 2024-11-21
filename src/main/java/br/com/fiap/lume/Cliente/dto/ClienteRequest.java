package br.com.fiap.lume.Cliente.dto;

import br.com.fiap.lume.Cliente.Cliente;

public record ClienteRequest(
        String id,
        String email,
        String senha
){
    public Cliente toModel() {
        return Cliente.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
