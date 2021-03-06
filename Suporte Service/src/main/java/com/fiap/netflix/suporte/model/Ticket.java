package com.fiap.netflix.suporte.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Ticket implements Serializable {

    @Id
    @Column(name = "id_ticket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_filme")
    private Long idFilme;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "desc_erro")
    private String descricaoErro;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Atendente atendente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public String toString() {
        return "[Ticket] -> " +
                "[id=" + id + "], " +
                "[idFilme=" + idFilme + "], " +
                "[idUsuario=" + idUsuario + "], " +
                "[descricaoErro=" + descricaoErro + "], " +
                "[dataCriacao=" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dataCriacao) + "], " +
                "[atendente=" + (atendente == null ? "0": atendente.getId()) + "]";
    }
}
