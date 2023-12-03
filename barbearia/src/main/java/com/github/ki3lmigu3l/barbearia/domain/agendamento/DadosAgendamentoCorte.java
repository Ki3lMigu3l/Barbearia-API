package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoCorte(

        @NotNull
        Long idCliente,
        Long idCorte,
        @NotNull
        @Future
        LocalDateTime data
) {
}
