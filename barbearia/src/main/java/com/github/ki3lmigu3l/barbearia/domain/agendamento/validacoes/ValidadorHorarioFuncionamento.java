package com.github.ki3lmigu3l.barbearia.domain.agendamento.validacoes;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosAgendamentoCorte;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento {

    public void validar(DadosAgendamentoCorte dados) {
        var dataDoAgendamento = dados.data();

        var domingo = dataDoAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataDoAgendamento.getHour() < 9;
        var depoisDoEncerramento = dataDoAgendamento.getHour() > 18;

        if (domingo || antesDaAbertura || depoisDoEncerramento) {
            throw new ValidacaoException("Agendamento fora do horario de funcionamento!");
        }
    }
}
