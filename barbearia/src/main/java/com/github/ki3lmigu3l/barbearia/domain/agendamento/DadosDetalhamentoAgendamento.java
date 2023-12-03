package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoAgendamento(

        Long id,
        Long idCliente,
        Long idCorte,
        LocalDateTime data
) {
    public DadosDetalhamentoAgendamento(Agendamento agendamento) {
        this(agendamento.getId(), agendamento.getCliente().getId(), agendamento.getCorte().getId(), agendamento.getData());
    }
}
