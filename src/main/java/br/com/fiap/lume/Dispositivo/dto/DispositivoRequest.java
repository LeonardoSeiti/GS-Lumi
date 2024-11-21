package br.com.fiap.lume.Dispositivo.dto;

import br.com.fiap.lume.Dispositivo.Dispositivo;

import java.time.LocalDateTime;

public record DispositivoRequest(
        Long id,
        String nome,
        String tipo,
        Float consumoMedio,
        LocalDateTime dataInstalacao
) {
    public Dispositivo toModel(){
     return Dispositivo.builder()
             .nome(nome)
             .tipo(tipo)
             .consumoMedio(consumoMedio)
             .dataInstalacao(dataInstalacao)
             .build();
    }
}
