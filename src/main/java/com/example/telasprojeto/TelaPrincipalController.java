package com.example.telasprojeto;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.MenuItem;
import javafx.fxml.FXMLLoader;


public class TelaPrincipalController {

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
    @FXML
    private void abrirTelaLavanderia() {
        try {
            // Carrega a tela de lavanderia
            HelloApplication.getInstance().carregarTela("tela-lavanderia.fxml", "Serviço de Lavanderia", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaSpa() {
        try {
            // Carrega a tela do spa
            HelloApplication.getInstance().carregarTela("tela-spa.fxml", "Serviço de SPA", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaTransporte() {
        try {
            // Carrega a tela de transporte
            HelloApplication.getInstance().carregarTela("tela-transporte.fxml", "Serviço de Transporte", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaServicoQuarto() {
        try {
            // Carrega a tela do serviço de quarto
            HelloApplication.getInstance().carregarTela("tela-servico-quarto.fxml", "Serviço de Quarto", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaAlimentacaoProdutos() {
        try {
            // Carrega a tela de Vendas de Alimentação e Produtos
            HelloApplication.getInstance().carregarTela("tela-alimentacao-produtos.fxml", "Serviço de Vendas de Alimentação e Produtos", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaFeedback() {
        try {
            // Carrega a tela de Feedback
            HelloApplication.getInstance().carregarTela("tela-feedback.fxml", "Feedback", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaReserva() {
        try {
            // Carrega a tela de Reserva
            HelloApplication.getInstance().carregarTela("tela-reserva.fxml", "Reserva", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaContaAtual() {
        try {
            // Carrega a tela Conta Atual
            HelloApplication.getInstance().carregarTela("tela-conta-atual.fxml", "Conta Atual", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void abrirTelaPagamento() {
        try {
            // Carrega a tela de Pagamento
            HelloApplication.getInstance().carregarTela("tela-pagamento.fxml", "Pagamento", 803, 675);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}