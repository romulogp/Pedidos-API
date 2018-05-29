package com.hustik.pedidosapi.domain;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
public enum StatusPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(2, "Cancelado");

    private final int cod;
    private final String descricao;

    private StatusPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (StatusPagamento tipo : StatusPagamento.values()) {
            if (cod.equals(tipo.getCod())) {
                return tipo;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }

}
