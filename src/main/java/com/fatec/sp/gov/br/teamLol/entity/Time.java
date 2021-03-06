package com.fatec.sp.gov.br.teamLol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    private String nome;

    @OneToOne
    @JoinColumn(name = "tme_coach",referencedColumnName = "cch_id")
    private Coach coach;

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
    
}
