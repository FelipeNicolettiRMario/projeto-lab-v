package com.fatec.sp.gov.br.teamLol.service;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.entity.Time;
import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;
import com.fatec.sp.gov.br.teamLol.repository.TimeRepository;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


@Service("jogadorService")
public class JogadorServiceImpl implements JogadorService {

    @Autowired 
    private JogadorRepository jogadorRepo;
    
    @Autowired
    private TimeRepository timeRepo;

    @Override
    @Transactional
    public Jogador adicionarJogador(String nick, String rank,String senha,String timeNome) {

        Time time = timeRepo.findTimeByNome(timeNome);
        
        if (time == null){
            time = new Time();
            time.setNome(timeNome);
            timeRepo.save(time);
        }


        Jogador jogador = new Jogador();
        jogador.setNick(nick);
        jogador.setRank(rank);
        jogador.setSenha(senha);
        jogador.setTime(time);

        jogadorRepo.save(jogador);

        return jogador;
    }

    @Override
    public List<Jogador> buscarTodosJogadores(){
        return jogadorRepo.findAll();
    }

    @Override
    public Optional<Jogador> atualizarJogador(String novoNick,String novoElo,Long id) {

        jogadorRepo.updateJogador(novoNick,novoElo,id);

        Optional <Jogador> jogador_atualizado = jogadorRepo.findById(id);

        if(jogador_atualizado.isPresent()){
            return jogador_atualizado;
        }

        return null;
    }

    @Override
    public Optional<Jogador> deletarJogador(Long id) {

        Optional<Jogador> jogador = jogadorRepo.findById(id);

         jogadorRepo.deleteJogador(id);

        return jogador;

    }
}
