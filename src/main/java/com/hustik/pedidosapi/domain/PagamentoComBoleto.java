package com.hustik.pedidosapi.domain;

import java.time.LocalDate;
import javax.persistence.Entity;

/**
 *
 * @author Rômulo Göelzer Portolann
 */
@Entity
public class PagamentoComBoleto extends Pagamento {
    
    private static final Long serialVersionUID = 1L;

    private LocalDate dataVencimento;
    private LocalDate dataPagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Long id, StatusPagamento status, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(id, status, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
