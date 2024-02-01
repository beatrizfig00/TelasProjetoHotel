package com.example.telasprojeto;

public class Lavanderia implements Servico {
    private String tipo;
    private double preco;

    public Lavanderia(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return tipo;
    }
}
