package com.github.ki3lmigu3l.barbearia.domain.corte;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DadosCadastroCorte(

        @NotBlank
        String nome,

        @PositiveOrZero
        @NotNull
        BigDecimal preco
) {
}
