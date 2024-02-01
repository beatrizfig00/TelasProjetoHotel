package com.example.telasprojeto;

import javafx.fxml.FXML;

import java.io.IOException;

public class TelaFeedbackController {
    @FXML
    private void voltarParaTelaPrincipal() {
        try {
            HelloApplication.getInstance().carregarTela("tela-principal.fxml", "Tela Principal", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
