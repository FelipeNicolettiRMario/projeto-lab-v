package com.fatec.sp.gov.br.teamLol.repository;

import com.fatec.sp.gov.br.teamLol.entity.Coach;
import com.fatec.sp.gov.br.teamLol.entity.Jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JogadorRepository extends JpaRepository<Jogador,Long>{

    @Query("SELECT j.time.coach from Jogador j inner join j.time where j.nick = ?1")
    public Coach findCoachFromJogador(String nome);

    public Jogador findJogadorByNickAndSenha(String nick,String senha);

}