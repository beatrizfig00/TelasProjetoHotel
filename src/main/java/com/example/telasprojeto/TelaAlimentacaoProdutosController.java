package com.example.telasprojeto;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import java.io.IOException;

public class TelaAlimentacaoProdutosController {

    @FXML
    private CheckBox cafeDaManhaCheckBox;

    @FXML
    private CheckBox almocoCheckBox;

    @FXML
    private CheckBox jantaCheckBox;

    @FXML
    private CheckBox coxinhaCheckBox;

    @FXML
    private CheckBox cookieCheckBox;

    @FXML
    private CheckBox frutasCheckBox;

    @FXML
    private CheckBox aguaCheckBox;

    @FXML
    private CheckBox boloCheckBox;

    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;

    private double cafeDaManha = 0.0; // Considerando que é grátis
    private double almoco = 30.0;
    private double janta = 20.0;
    private double coxinha = 4.0;
    private double cookie = 3.0;
    private double frutas = 10.0;
    private double agua = 2.0;
    private double bolo = 5.0;

    // Adicionei um parâmetro para o loginHospede no initialize
    @FXML
    private void initialize(String loginHospede) {
        this.contaAtual = new ContaAtual(loginHospede);
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (cafeDaManhaCheckBox.isSelected()) {
            Servico cafeDaManhaServico = new Produto("Café da Manhã", cafeDaManha);
            processarServico(cafeDaManhaServico);
            valorTotal += cafeDaManhaServico.getPreco();
        }

        if (almocoCheckBox.isSelected()) {
            Servico almocoServico = new Produto("Almoço", almoco);
            processarServico(almocoServico);
            valorTotal += almocoServico.getPreco();
        }

        if (jantaCheckBox.isSelected()) {
            Servico jantaServico = new Produto("Janta", janta);
            processarServico(jantaServico);
            valorTotal += jantaServico.getPreco();
        }

        if (coxinhaCheckBox.isSelected()) {
            Servico coxinhaServico = new Produto("Coxinha", coxinha);
            processarServico(coxinhaServico);
            valorTotal += coxinhaServico.getPreco();
        }

        if (cookieCheckBox.isSelected()) {
            Servico cookieServico = new Produto("Cookie", cookie);
            processarServico(cookieServico);
            valorTotal += cookieServico.getPreco();
        }

        if (frutasCheckBox.isSelected()) {
            Servico frutasServico = new Produto("Frutas", frutas);
            processarServico(frutasServico);
            valorTotal += frutasServico.getPreco();
        }

        if (aguaCheckBox.isSelected()) {
            Servico aguaServico = new Produto("Água", agua);
            processarServico(aguaServico);
            valorTotal += aguaServico.getPreco();
        }

        if (boloCheckBox.isSelected()) {
            Servico boloServico = new Produto("Bolo", bolo);
            processarServico(boloServico);
            valorTotal += boloServico.getPreco();
        }

        valorTotalLabel.setText("Valor Total: R$ " + String.format("%.2f", valorTotal));
    }

    private void processarServico(Servico servico) {
        contaAtual.adicionarServico(servico);
        Transacao transacao = new Transacao(contaAtual.getLoginHospede(), servico.getNome(), servico.getPreco());
        ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
    }

    @FXML
    private void voltarParaTelaPrincipal() {
        try {
            HelloApplication.getInstance().carregarTela("tela-principal.fxml", "Tela Principal", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
