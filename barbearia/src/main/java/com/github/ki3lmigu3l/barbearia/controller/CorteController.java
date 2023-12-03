package com.github.ki3lmigu3l.barbearia.controller;

import com.github.ki3lmigu3l.barbearia.domain.corte.CorteDeCabelo;
import com.github.ki3lmigu3l.barbearia.domain.corte.CorteDeCabeloRepository;
import com.github.ki3lmigu3l.barbearia.domain.corte.DadosCadastroCorte;
import com.github.ki3lmigu3l.barbearia.domain.corte.DadosDetalhamentoCorte;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("corte")
public class CorteController {

    @Autowired
    private CorteDeCabeloRepository corteDeCabeloRepository;

    @PostMapping
    public ResponseEntity criarCorte (@RequestBody @Valid DadosCadastroCorte dados) {
        var corte = new CorteDeCabelo(dados);
        corteDeCabeloRepository.save(corte);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DadosDetalhamentoCorte(corte));
    }
}
