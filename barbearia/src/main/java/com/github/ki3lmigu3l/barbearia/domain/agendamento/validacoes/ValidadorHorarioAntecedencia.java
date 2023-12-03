package com.github.ki3lmigu3l.barbearia.domain.agendamento.validacoes;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosAgendamentoCorte;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamento {

    public void validar(DadosAgendamentoCorte dados) {
        var dataAgentamento = dados.data();
        var horarioAgora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(horarioAgora, dataAgentamento).toMinutes();


        if (diferencaMinutos < 15) {
            throw new ValidacaoException("Consulta deve ser agendada com antecendecia mínima de 15 minutos");
        }
    }
}
