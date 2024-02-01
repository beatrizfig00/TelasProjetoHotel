package com.example.telasprojeto;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class TelaAdmPrincipalController {
    @FXML
    public void voltarParaLogin() {
        try {
            // Carrega a tela de login
            HelloApplication.getInstance().carregarTela("tela-login.fxml", "Tela de Login", 620, 480);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void SairButton() {
        Platform.exit();
        System.exit(0);
    }
}
