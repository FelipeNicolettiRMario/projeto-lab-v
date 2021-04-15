package com.fatec.sp.gov.br.teamLol.controller;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.*;

import com.fatec.sp.gov.br.entity.Jogador;
import com.fatec.sp.gov.br.service.JogadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/jogador")
@CrossOrigin
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping(value = "/todos")
    public List<Jogador> buscarTodos(){
        return jogadorService.buscarTodosJogadores();
    }

}




