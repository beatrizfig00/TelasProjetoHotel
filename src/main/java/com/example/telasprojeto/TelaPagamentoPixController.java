package com.example.telasprojeto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import java.io.IOException;

public class TelaPagamentoPixController {
    private PagamentoPorPix pagamentoPorPix;

    @FXML
    private void voltarParaTelaPagamento() {
        try {
            HelloApplication.getInstance().carregarTela("tela-pagamento.fxml", "Tela Pagamento", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void SairButton() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void confirmarPagamento() {
        pagamentoPorPix = new PagamentoPorPix(0.0, null, 0);
        pagamentoPorPix.realizarPagamento();
    }
}
