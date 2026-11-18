package com.trilhaspringboot.aprendendospringboot.business;

import com.trilhaspringboot.aprendendospringboot.exceptions.ConflictException;
import com.trilhaspringboot.aprendendospringboot.exceptions.ResourceNotFoundException;
import com.trilhaspringboot.aprendendospringboot.infrastructure.entity.Usuario;
import com.trilhaspringboot.aprendendospringboot.infrastructure.repository.UsuarioRepository;
import io.jsonwebtoken.security.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario salvaUsuario(Usuario usuario) {
        verificaEmailExistente(usuario.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public void emailExiste(String email) {
        if (verificaEmailExistente(email)) {
            throw new ConflictException("Email já cadastrado" + email);
        }
    }


    public boolean verificaEmailExistente(String email) {
        return usuarioRepository.existsByEmail(email);
    }


    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Email não encontrado"+ email));
    }

    public void deletaUsuarioPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
}
