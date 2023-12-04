package com.github.ki3lmigu3l.barbearia.domain.usuario;

public record RegristrarUsuarioDTO(
        String login,
        String senha,
        UsuarioRole role
) {
}
