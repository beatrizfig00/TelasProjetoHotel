package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;

public class TelaContaAtualController {

    @FXML
    private void voltarParaTelaPrincipal() {
        try {
            HelloApplication.getInstance().carregarTela("tela-principal.fxml", "Tela Principal", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirTelaPagamento() {
        try {
            // Carrega a tela de pagamento ou inicia o processo de pagamento
            HelloApplication.getInstance().carregarTela("tela-pagamento.fxml", "Pagamento", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
