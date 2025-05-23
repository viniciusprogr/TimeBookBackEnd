package com.agenda.Timebook.dtos.input;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @Email(message = "Email invalido!")
    @NotBlank(message = "Email não pode ser nulo")
    private String email;

    @NotBlank(message = "Senha não pode ser nulo")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    private String senha;

}
