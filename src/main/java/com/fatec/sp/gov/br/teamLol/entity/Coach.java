package com.fatec.sp.gov.br.teamLol.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.teamLol.controller.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cch_coach")
public class Coach {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cch_id")
    @JsonView(View.JogadorCompleto.class)
    private Long id;

    @JsonView(View.JogadorResumo.class)
    @Column(name = "cch_nome")
    private String nome;

    @Column(name = "cch_senha")
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
