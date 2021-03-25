package com.fatec.sp.gov.br.teamLol.repository;

import java.util.Set;

import com.fatec.sp.gov.br.teamLol.entity.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimeRepository extends JpaRepository<Time,Long>{
    
    public Time findByNome(String nome);
}
