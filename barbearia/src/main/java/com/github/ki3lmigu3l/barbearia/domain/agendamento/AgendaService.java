package com.github.ki3lmigu3l.barbearia.domain.agendamento;

import com.github.ki3lmigu3l.barbearia.domain.cliente.ClienteRepository;
import com.github.ki3lmigu3l.barbearia.domain.corte.CorteDeCabelo;
import com.github.ki3lmigu3l.barbearia.domain.corte.CorteDeCabeloRepository;
import com.github.ki3lmigu3l.barbearia.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CorteDeCabeloRepository corteRepository;


    public void agendar(DadosAgendamentoCorte dados) {

        if (!corteRepository.existsById(dados.idCorte())) {
            throw new ValidacaoException("Corte não existe!");
        }

        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new ValidacaoException("Cliente não existe!");
        }

        var cliente = clienteRepository.findById(dados.idCliente()).get();
        var corte = corteRepository.findById(dados.idCorte()).get();
        var agendamento = new Agendamento(null, cliente, corte, dados.data());
        agendamentoRepository.save(agendamento);
    }
}
