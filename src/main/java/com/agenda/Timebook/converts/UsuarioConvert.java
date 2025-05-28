package com.agenda.Timebook.converts;

import com.agenda.Timebook.configs.ModelMapperConfig;
import com.agenda.Timebook.dtos.input.UsuarioInput;
import com.agenda.Timebook.dtos.output.UsuarioOutput;
import com.agenda.Timebook.entitites.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConvert {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioEntity inputToEntity(Object input){
        return modelMapper.map(input, UsuarioEntity.class);
    }

    public UsuarioOutput entityToOutput(UsuarioEntity usuarioCadastrado) {
    return modelMapper.map(usuarioCadastrado, UsuarioOutput.class);
    }

    public void copyToEntity(UsuarioInput usuarioInput, UsuarioEntity usuarioEncontrado) {
        modelMapper.map(usuarioInput, usuarioEncontrado);
    }
}
