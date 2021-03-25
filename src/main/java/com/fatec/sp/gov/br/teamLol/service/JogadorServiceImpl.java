package com.fatec.sp.gov.br.teamLol.service;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("jogadorService")
public class JogadorServiceImpl implements JogadorService {

    @Autowired 
    private JogadorRepository jogadorRepo;
    

    @Override
    @Transactional
    public Jogador adicionarJogador(String nick, String rank,String senha) {

        Jogador jogador = new Jogador();
        jogador.setNick(nick);
        jogador.setRank(rank);
        jogador.setSenha(senha);
        
        jogadorRepo.save(jogador);

        return jogador;
    }
    
}
