package com.example.telasprojeto;

import java.util.ArrayList;

public class RepositorioPagamento {
    private ArrayList<Pagamento> pagamentos;

    public RepositorioPagamento(ArrayList<Pagamento> pagamentos) {

        this.pagamentos = pagamentos;
    }

    public void adicionarPagamento (Pagamento pagamento) {
        pagamentos.add(pagamento);
    }
    public ArrayList<Pagamento> getAllPagamentos () {
        return pagamentos;
    }

    public void removerPagamento(int identificador) {
        pagamentos.removeIf(pagamento -> pagamento.getIdentificador() == identificador);
    }
    public Pagamento getPagamentoPorIdentificador(int identificador) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getIdentificador() == identificador) {
                return pagamento;
            }
        }
        return null;
    }
}
