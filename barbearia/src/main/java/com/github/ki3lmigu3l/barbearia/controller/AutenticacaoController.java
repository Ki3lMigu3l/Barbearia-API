package com.github.ki3lmigu3l.barbearia.controller;

import com.github.ki3lmigu3l.barbearia.domain.usuario.AunteticacaoUsuarioDTO;
import com.github.ki3lmigu3l.barbearia.domain.usuario.RegristrarUsuarioDTO;
import com.github.ki3lmigu3l.barbearia.domain.usuario.Usuario;
import com.github.ki3lmigu3l.barbearia.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

   @Autowired
   private AuthenticationManager authenticationManagerBean;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AunteticacaoUsuarioDTO usuarioDTO) {
        var usuario = new UsernamePasswordAuthenticationToken(usuarioDTO.login(), usuarioDTO.senha());
        var auth = authenticationManagerBean.authenticate(usuario);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity registrar (@RequestBody RegristrarUsuarioDTO usuarioDTO) {
        if (this.usuarioRepository.findByLogin(usuarioDTO.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedSenha = new BCryptPasswordEncoder().encode(usuarioDTO.senha());
        var usuario = new Usuario(usuarioDTO.login(), encryptedSenha, usuarioDTO.role());

        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
