package com.example.telasprojeto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.io.IOException;

public class TelaReservaController {
    @FXML
    private DatePicker checkinDatePicker;
    @FXML
    private DatePicker checkoutDatePicker;
    @FXML
    private ComboBox<String> tipoQuartoComboBox;
    @FXML
    private Button verificarDisponibilidadeButton;

    @FXML
    private void verificarDisponibilidade() {
        // Lógica para verificar disponibilidade com base nas escolhas do usuário
        String checkin = checkinDatePicker.getValue().toString();
        String checkout = checkoutDatePicker.getValue().toString();
        String tipoQuarto = tipoQuartoComboBox.getValue();

        // Adicione a lógica de verificação de disponibilidade aqui
        System.out.println("Verificando disponibilidade para: Check-in=" + checkin + ", Check-out=" + checkout + ", Tipo de Quarto=" + tipoQuarto);
    }

    @FXML
    private void voltarParaTelaPrincipal() {
        try {
            // Carrega a tela principal
            HelloApplication.getInstance().carregarTela("tela-principal.fxml", "Tela Principal do Hóspede", 1300, 800);
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