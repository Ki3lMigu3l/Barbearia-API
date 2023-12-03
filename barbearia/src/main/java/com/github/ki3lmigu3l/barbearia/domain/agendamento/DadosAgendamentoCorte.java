package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoCorte(
        Long idCorte,

        @NotNull
        Long idCliente,

        @NotNull
        @Future
        LocalDateTime data
) {
}
