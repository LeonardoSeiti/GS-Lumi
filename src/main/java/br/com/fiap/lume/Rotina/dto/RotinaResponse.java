package br.com.fiap.lume.Rotina.dto;

import br.com.fiap.lume.Rotina.Rotina;

import java.time.LocalDateTime;

public record RotinaResponse(
        Long id,
        String nome,
        String descricao,
        String horaInicio,
        String horaFim
) {
    public static RotinaResponse from (Rotina rotina){
        return new RotinaResponse(
                rotina.getId(),
                rotina.getNome(),
                rotina.getDescricao(),
                rotina.getHoraInicio(),
                rotina.getHoraFim()
        );
    }
}
