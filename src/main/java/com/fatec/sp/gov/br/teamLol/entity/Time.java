package com.fatec.sp.gov.br.teamLol.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.teamLol.controller.View;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tme_time")
public class Time {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tme_id")
    private Long id;

    @Column(name = "tme_nome")
    @JsonView(View.JogadorResumo.class)
    private String nome;

    @OneToOne
    @JsonView(View.JogadorCompleto.class)
    @JoinColumn(name = "tme_coach",referencedColumnName = "cch_id")
    private Coach coach;

    @OneToMany(mappedBy = "time")
    public Set<Jogador> jogadores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
}
