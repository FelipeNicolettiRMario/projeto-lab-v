package com.fatec.sp.gov.br.teamLol.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    @JsonView(View.JogadorCompleto.class)
    public Jogador inserirJogador(@RequestBody Jogador jogador){ return jogadorService.adicionarJogador(jogador.getNick(),
            jogador.getSenha(),
            jogador.getRank(),
            jogador.getTime().getNome()); }

    @PutMapping(value = "/{id}")
    @JsonView(View.JogadorResumo.class)
    public Optional<Jogador> atualizarJogador(@PathVariable(value = "id") Long id,
                                              @RequestParam(value = "novoNome") String novoNome,
                                              @RequestParam(value = "novoElo") String novoElo){
        return jogadorService.atualizarJogador(novoNome,novoElo,id);

    }

    @DeleteMapping(value = "/{id}")
    @JsonView(View.JogadorResumo.class)
    public Optional<Jogador> removerJogador(@PathVariable(value ="id") Long id){

        return jogadorService.deletarJogador(id);
    }
}




