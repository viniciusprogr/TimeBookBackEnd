package com.agenda.Timebook.controllers;

import com.agenda.Timebook.converts.UsuarioConvert;
import com.agenda.Timebook.dtos.input.UsuarioInput;
import com.agenda.Timebook.dtos.output.UsuarioOutput;
import com.agenda.Timebook.entitites.UsuarioEntity;
import com.agenda.Timebook.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/remover/{id}")
    public void removerUsuario(@PathVariable Long id){
        UsuarioEntity usuarioEncontrado = usuarioService.buscarPorId(id);
        usuarioService.deletarUsuario(usuarioEncontrado);
    }

    @RequestMapping("/buscarPorId/{id}")
    public UsuarioOutput buscarPorId(@PathVariable Long id){
        UsuarioEntity usuarioEncontrado = usuarioService.buscarPorId(id);
        return usuarioConvert.entityToOutput(usuarioEncontrado);
    }

    @PutMapping("/atualizar/{id}")
    public UsuarioOutput atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioInput usuarioInput){
        UsuarioEntity usuarioEncontrado = usuarioService.buscarPorId(id);
        usuarioConvert.copyToEntity(usuarioInput, usuarioEncontrado);
        UsuarioEntity usuarioAtualizado = usuarioService.atualizarUsuario(usuarioEncontrado);
        return usuarioConvert.entityToOutput(usuarioAtualizado);
    }
}
