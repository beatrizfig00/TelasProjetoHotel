package com.example.telasprojeto;

import java.time.LocalDate;

public abstract class Pagamento {
    protected double valor;
    protected LocalDate dataPagamento;
    protected int identificador;

    public Pagamento(double valor, LocalDate dataPagamento, int identificador) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.identificador = identificador;
    }

    public abstract void realizarPagamento();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
