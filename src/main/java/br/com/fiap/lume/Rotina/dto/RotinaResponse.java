package br.com.fiap.lume.Rotina.dto;

import br.com.fiap.lume.Rotina.Rotina;


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
