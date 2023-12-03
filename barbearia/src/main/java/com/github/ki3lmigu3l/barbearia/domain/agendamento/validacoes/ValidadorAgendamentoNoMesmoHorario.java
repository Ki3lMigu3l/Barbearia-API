package com.github.ki3lmigu3l.barbearia.domain.agendamento.validacoes;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.AgendamentoRepository;
import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosAgendamentoCorte;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAgendamentoNoMesmoHorario implements ValidadorAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void validar(DadosAgendamentoCorte dados) {
        var clientePossuiOutroAgendamento = agendamentoRepository.existsByClienteIdAndData(dados.idCliente(), dados.data());

        if (clientePossuiOutroAgendamento) {
            throw new ValidacaoException("Cliente já possui outro agendamento nesse mesmo horário");
        }
    }
}
