package com.agenda.Timebook.services;

import com.agenda.Timebook.entitites.UsuarioEntity;
import com.agenda.Timebook.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuarioEntity){
       if (vericaEmailExistente(usuarioEntity.getEmail())){

           return usuarioRepository.save(usuarioEntity);

       }else throw new RuntimeException("Email já cadastrado");
    }

    public boolean vericaEmailExistente(String email) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);
        if (usuarioEntity == null) {
            return true;
        } else {
            return false;
        }
    }
}
