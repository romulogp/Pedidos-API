package com.hustik.pedidosapi.domain;

import javax.persistence.Entity;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Entity
public class PagamentoComCartao extends Pagamento {
    
    private static final Long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Long id, StatusPagamento status, Pedido pedido, Integer numeroParcelas) {
        super(id, status, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

}
