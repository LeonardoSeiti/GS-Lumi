package br.com.fiap.lume.Rotina.dto;

import br.com.fiap.lume.Rotina.Rotina;


public record RotinaRequest(
        Long id,
        String nome,
        String descricao,
        String horaInicio,
        String horaFim
) {
    public Rotina toModel(){
        return Rotina.builder()
                .nome(nome)
                .descricao(descricao)
                .horaInicio(horaInicio)
                .horaFim(horaFim)
                .build();
    }
}
