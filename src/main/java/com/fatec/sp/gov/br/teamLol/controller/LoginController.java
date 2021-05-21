package com.fatec.sp.gov.br.teamLol.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fatec.sp.gov.br.teamLol.security.JwtUtils;
import com.fatec.sp.gov.br.teamLol.security.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping()
    public Login autenticar(@RequestBody Login login) {

        Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword());
        auth = authManager.authenticate(auth);
        login.setPassword(null);
        try {
            login.setToken(JwtUtils.generateToken(auth));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return login;
    }

}
