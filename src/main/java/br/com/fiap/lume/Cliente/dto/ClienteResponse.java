package br.com.fiap.lume.Cliente.dto;

import br.com.fiap.lume.Cliente.Cliente;

public record ClienteResponse(
        Long id,
        String email,
        String senha) {
    public static ClienteResponse from(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getEmail(),
                cliente.getSenha());
    }
}
