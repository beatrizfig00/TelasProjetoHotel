package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;

public class TelaPagamentoController {
    @FXML
    private void voltarParaTelaPrincipal() {
        try {
            HelloApplication.getInstance().carregarTela("tela-principal.fxml", "Tela Principal", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void TelaPagamentoPix() {
        try {
            HelloApplication.getInstance().carregarTela("tela-pagamento-pix.fxml", "Tela Pagamento Pix", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void TelaPagamentoDinheiro() {
        try {
            HelloApplication.getInstance().carregarTela("tela-pagamento-dinheiro.fxml", "Tela Pagamento Dinheiro", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void TelaPagamentoCartao() {
        try {
            HelloApplication.getInstance().carregarTela("tela-pagamento-cartao.fxml", "Tela Pagamento Cartão", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
