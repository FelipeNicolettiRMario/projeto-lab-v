package com.fatec.sp.gov.br.teamLol.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fatec.sp.gov.br.teamLol.security.JwtUtils;
import com.fatec.sp.gov.br.teamLol.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;
import com.fatec.sp.gov.br.teamLol.entity.Jogador;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private JogadorRepository jogadorRep;

    @PostMapping()
    public Login autenticar(@RequestBody Login login) {

        Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword());
        auth = authManager.authenticate(auth);
        login.setPassword(null);
        
        Jogador jogador = jogadorRep.findJogadorByNick(login.getUsername());
        login.setAutorizacoes(jogador.getRole());

        try {
            login.setToken(JwtUtils.generateToken(auth));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return login;
    }

}
