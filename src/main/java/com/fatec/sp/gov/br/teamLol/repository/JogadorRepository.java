package com.fatec.sp.gov.br.teamLol.repository;

import com.fatec.sp.gov.br.teamLol.entity.Coach;
import com.fatec.sp.gov.br.teamLol.entity.Jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface JogadorRepository extends JpaRepository<Jogador,Long>{

    @Query("SELECT j.time.coach from Jogador j inner join j.time where j.nick = ?1")
    public Coach findCoachFromJogador(String nome);

    @Transactional
    @Modifying
    @Query("UPDATE Jogador j set j.nick = ?1 , j.rank = ?2 where j.id = ?3")
    public void updateJogador(String nick,String rank,Long id);

    public Jogador findJogadorByNickAndSenha(String nick,String senha);

    public Jogador findJogadorByNick(String nick);

}