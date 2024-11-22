package br.com.fiap.lume.Rotina;

import br.com.fiap.lume.Dispositivo.Dispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_rotina")
public class Rotina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String horaInicio;
    private String horaFim;

    @ManyToOne
    Dispositivo dispositivo;
}
