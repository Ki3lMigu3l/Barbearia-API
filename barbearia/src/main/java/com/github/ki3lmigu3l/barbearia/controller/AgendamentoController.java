package com.github.ki3lmigu3l.barbearia.controller;

import com.github.ki3lmigu3l.barbearia.domain.agendamento.AgendaService;
import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosAgendamentoCorte;
import com.github.ki3lmigu3l.barbearia.domain.agendamento.DadosDetalhamentoAgendamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoCorte dados) {
        agendaService.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAgendamento(null, null, null, null));
    }
}
