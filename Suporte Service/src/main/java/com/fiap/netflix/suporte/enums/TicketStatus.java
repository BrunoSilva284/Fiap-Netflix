package com.fiap.netflix.suporte.enums;

public enum TicketStatus {

    CRIADO(1, "Chamado aberto."),
    EM_ATENDIMENTO(2, "Chamado em atendimento."),
    RESOLVIDO(3, "Chamado resolvido."),
    FECHADO(4, "Chamado fechado."),
    INDEFINIDO(0, "Status indefinido.");

    private int codigo;
    private String descricao;

    TicketStatus(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
