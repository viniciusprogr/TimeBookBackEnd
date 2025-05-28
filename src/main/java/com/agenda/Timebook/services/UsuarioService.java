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

    @Transactional
    public UsuarioEntity atualizarUsuario(UsuarioEntity usuarioEntity){
        return usuarioRepository.save(usuarioEntity);
    }

    public boolean vericaEmailExistente(String email) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email);
        if (usuarioEntity == null) {
            return true;
        } else {
            return false;
        }
    }

    public UsuarioEntity buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void deletarUsuario(UsuarioEntity usuarioEncontrado) {
        usuarioRepository.delete(usuarioEncontrado);
    }
}
