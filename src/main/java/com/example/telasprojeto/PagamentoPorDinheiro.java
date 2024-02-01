package com.example.telasprojeto;

import java.time.LocalDate;

public class PagamentoPorDinheiro extends Pagamento {
    private double dinheirorecebido;
    private double troco;

    public PagamentoPorDinheiro(double valor, LocalDate dataPagamento, int identificador, double dinheirorecebido, double troco) {
        super(valor, dataPagamento, identificador);
        this.dinheirorecebido = dinheirorecebido;
        this.troco = troco;
    }

    @Override
    public void realizarPagamento() {
        calcularTroco();
        System.out.println("Pagamento recebido. Obrigado!");
    }

    private void calcularTroco() {
        troco = dinheirorecebido - getValor();
        if (troco >= 0) {
            System.out.println("Troco: R$ " + troco);
        } else {
            System.out.println("Valor insuficiente");
        }
    }

    public double getRecebido() {

    return dinheirorecebido;
    }
    public void setRecebido(double dinheirorecebido) {

    this.dinheirorecebido = dinheirorecebido;
    }
    public double getTroco() {

    return troco;
    }
    public void setTroco(double troco) {

    this.troco = troco;
    }
}