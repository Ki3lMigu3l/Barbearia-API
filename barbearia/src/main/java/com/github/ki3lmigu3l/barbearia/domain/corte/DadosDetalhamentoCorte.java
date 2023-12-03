package com.github.ki3lmigu3l.barbearia.domain.corte;

import java.math.BigDecimal;

public record DadosDetalhamentoCorte(String nome, BigDecimal preco) {
    public DadosDetalhamentoCorte(CorteDeCabelo corte) {
        this (corte.getNome(), corte.getPreco());
    }
}
