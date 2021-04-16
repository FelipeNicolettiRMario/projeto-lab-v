package com.fatec.sp.gov.br.teamLol.service;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;

import java.util.*;

public interface JogadorService {
    public Jogador adicionarJogador(String nick,String rank,String senha,String timeNome);

    public List<Jogador> buscarTodosJogadores();

    public Optional<Jogador> atualizarJogador(String novoNick,String novoElo,Long id);
}
