package com.github.ki3lmigu3l.barbearia.domain.agendamento.validacoes;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.AgendamentoRepository;
import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosAgendamentoCorte;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorClienteSemAgendamentoNoDia implements ValidadorAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void validar (DadosAgendamentoCorte dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);

        var clientePossuiConsultaNoDia = agendamentoRepository
                .existsByClienteIdAndDataBetween(dados.idCliente(), primeiroHorario, ultimoHorario);

        if (clientePossuiConsultaNoDia) {
            throw new ValidacaoException("Cliente já possui uma consulta agendada para este dia!");
        }
    }
}
