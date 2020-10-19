package com.fiap.netflix.suporte.model;

import javax.persistence.*;

@Entity
public class Atendente {

    @Id
    @Column(name = "id_atendente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_atendente")
    private String nome;

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
}
