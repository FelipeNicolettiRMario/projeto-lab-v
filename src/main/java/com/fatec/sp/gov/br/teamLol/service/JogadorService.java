package com.fatec.sp.gov.br.teamLol.service;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.*;

public interface JogadorService extends UserDetailsService {
    public Jogador adicionarJogador(String nick,String rank,String senha,String timeNome);

    public List<Jogador> buscarTodosJogadores();

    public Optional<Jogador> atualizarJogador(String novoNick,String novoElo,Long id);

    public Optional<Jogador> deletarJogador(Long id);
}
