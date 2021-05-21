package com.fatec.sp.gov.br.teamLol.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.sp.gov.br.teamLol.controller.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jgd_jogador")
public class Jogador{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jgd_id")
    @JsonView(View.JogadorCompleto.class)
    private Long id;

    @JsonView(View.JogadorResumo.class)
    @Column(name = "jgd_nick")
    private String nick;

    @JsonView(View.JogadorResumo.class)
    @Column(name = "jgd_rank")
    private String rank;

    @Column(name = "jgd_senha")
    private String senha;

    @ManyToOne
    @JsonView(View.JogadorCompleto.class)
    @JoinColumn(name = "jgd_time")
    private Time time;

    @Column(name = "jgd_role")
    private String role;

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
