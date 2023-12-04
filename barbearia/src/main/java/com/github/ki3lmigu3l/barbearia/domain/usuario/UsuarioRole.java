package com.github.ki3lmigu3l.barbearia.domain.usuario;

public enum UsuarioRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    UsuarioRole (String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
