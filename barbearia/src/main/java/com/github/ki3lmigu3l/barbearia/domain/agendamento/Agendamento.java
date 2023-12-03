package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import com.github.ki3lmigu3l.barbearia.domain.cliente.Cliente;
import com.github.ki3lmigu3l.barbearia.domain.corte.CorteDeCabelo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corte_id")
    private CorteDeCabelo corte;

    private LocalDateTime dataHora;
}
