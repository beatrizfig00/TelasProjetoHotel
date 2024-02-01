package com.example.telasprojeto;

import java.time.LocalDate;

public class PagamentoPorPix extends Pagamento {

    public PagamentoPorPix(double valor, LocalDate dataPagamento, int identificador) {
        super(valor, dataPagamento, identificador);
    }

    @Override
    public void realizarPagamento() {

        System.out.println("Pagamento recebido. Obrigado!");
    }
}
