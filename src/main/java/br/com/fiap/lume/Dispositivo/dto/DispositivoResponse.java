package br.com.fiap.lume.Dispositivo.dto;

import br.com.fiap.lume.Dispositivo.Dispositivo;

import java.time.LocalDateTime;

public record DispositivoResponse(
        Long id,
        String nome,
        String tipo,
        Float consumoMedio,
        LocalDateTime dataInstalacao
) {
    public static DispositivoResponse from (Dispositivo dispositivo){
        return new DispositivoResponse(
                dispositivo.getId(),
                dispositivo.getNome(),
                dispositivo.getTipo(),
                dispositivo.getConsumoMedio(),
                dispositivo.getDataInstalacao());

    }
}
