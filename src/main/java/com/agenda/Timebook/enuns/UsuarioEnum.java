package com.agenda.Timebook.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UsuarioEnum {
    Cliente("cliente"),
    Prestador("prestador"),
    Administrador("administrador");

    private String role;
}
