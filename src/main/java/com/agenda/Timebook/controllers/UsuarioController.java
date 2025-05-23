package com.agenda.Timebook.controllers;

import com.agenda.Timebook.converts.UsuarioConvert;
import com.agenda.Timebook.dtos.input.UsuarioInput;
import com.agenda.Timebook.dtos.output.UsuarioOutput;
import com.agenda.Timebook.entitites.UsuarioEntity;
import com.agenda.Timebook.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioConvert usuarioConvert;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/cadastrar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioOutput cadastrarUsuario(@RequestBody UsuarioInput usuarioInput)  {
        UsuarioEntity usuarioEntity = usuarioConvert.inputToEntity(usuarioInput);
        UsuarioEntity usuarioCadastrado = usuarioService.cadastrarUsuario(usuarioEntity);
        return usuarioConvert.entityToOutput(usuarioCadastrado);
    }
}
