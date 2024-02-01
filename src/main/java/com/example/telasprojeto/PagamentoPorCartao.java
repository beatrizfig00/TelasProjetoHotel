package com.example.telasprojeto;

import java.time.LocalDate;

public class PagamentoPorCartao extends Pagamento {
    private String numeroCartao;
    private String tipoCartao;  // Crédito ou Débito
    private int numeroParcelas;

    public PagamentoPorCartao(double valor, LocalDate dataPagamento, int identificador, String numeroCartao, String tipoCartao, int numeroParcelas) {
        super(valor, dataPagamento, identificador);
        this.numeroCartao = numeroCartao;
        this.tipoCartao = tipoCartao;
        this.numeroParcelas = numeroParcelas;
    }

    @Override
    public void realizarPagamento() {
        if ("Crédito".equalsIgnoreCase(tipoCartao)) {
            double valorParcela = getValor() / numeroParcelas;

            // Lógica de pagamento parcelado
            for (int i = 1; i <= numeroParcelas; i++) {
                System.out.println("Pagamento parcelado " + i + " de " + numeroParcelas + ": R$ " + valorParcela);
            }
        } else if ("Débito".equalsIgnoreCase(tipoCartao)) {
            // Lógica para pagamento com cartão de débito
            System.out.println("Pagamento no débito: " + getValor());
        } else {
            System.out.println("Tipo de cartão inválido");
        }
    }
}
