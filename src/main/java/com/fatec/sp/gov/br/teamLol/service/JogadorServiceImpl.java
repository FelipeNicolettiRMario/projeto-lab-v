package com.fatec.sp.gov.br.teamLol.service;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.entity.Time;
import com.fatec.sp.gov.br.teamLol.repository.JogadorRepository;
import com.fatec.sp.gov.br.teamLol.repository.TimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


@Service("jogadorService")
public class JogadorServiceImpl implements JogadorService {

    @Autowired 
    private JogadorRepository jogadorRepo;
    
    @Autowired
    private TimeRepository timeRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @Override
    @Transactional
    public Jogador adicionarJogador(String nick,String senha,String rank,String timeNome) {

        Time time = timeRepo.findTimeByNome(timeNome);
        
        if (time == null){
            time = new Time();
            time.setNome(timeNome);
            timeRepo.save(time);
        }


        Jogador jogador = new Jogador();
        jogador.setNick(nick);
        jogador.setRank(rank);
        jogador.setSenha(this.passEncoder.encode(senha));
        jogador.setTime(time);
        jogador.setRole("ROLE_USUARIO");

        jogadorRepo.save(jogador);

        return jogador;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Jogador> buscarTodosJogadores(){
        return jogadorRepo.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Optional<Jogador> atualizarJogador(String novoNick,String novoElo,Long id) {

        jogadorRepo.updateJogador(novoNick,novoElo,id);

        Optional <Jogador> jogador_atualizado = jogadorRepo.findById(id);

        if(jogador_atualizado.isPresent()){
            return jogador_atualizado;
        }

        return null;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Optional<Jogador> deletarJogador(Long id) {

        Optional<Jogador> jogador = jogadorRepo.findById(id);

         jogadorRepo.deleteJogador(id);

        return jogador;

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Jogador jogador = jogadorRepo.findJogadorByNick(s);
        if (jogador == null) {
            throw new UsernameNotFoundException("Usuario " + s + " não encontrado");
        }
        String[] roles = {jogador.getRole()};
        return User.builder().username(s).password(jogador.getSenha())
                .authorities(roles)
                .build();
    }
}
