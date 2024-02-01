package com.example.telasprojeto;

public class Transporte implements Servico {
    private String tipo;
    private double preco;

    public Transporte(String tipo, double preco) {
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

    // Se houver outros métodos ou campos específicos da classe Transporte, você pode adicioná-los aqui
}
