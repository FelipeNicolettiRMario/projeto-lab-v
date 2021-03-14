package com.fatec.sp.gov.br.teamLol.repository;

import java.util.Set;

import com.fatec.sp.gov.br.teamLol.entity.Jogador;
import com.fatec.sp.gov.br.teamLol.entity.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimeRepository extends JpaRepository<Time,Long>{
    
    public Time findByNome(String nome);

    @Query("SELECT t.jogadores from Time t inner join t.coach where t.nome = ?2 and t.coach.nome = ?1")
    public Set<Jogador> findJogadoresByCoachAndTime(String coach,String time);
}
