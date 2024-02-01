package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TelaServicoQuartoController {

    @FXML
    private CheckBox entregajornalCheckBox;

    @FXML
    private CheckBox limpezaquartoCheckBox;

    @FXML
    private CheckBox kithigieneCheckBox;

    @FXML
    private CheckBox decoracaoespecialCheckBox;

    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;

    private double entregajornal = 2.0;
    private double limpezaquarto = 10.0;
    private double kithigiene = 25.0;
    private double decoracaoespecial = 30.0;

    @FXML
    private void initialize(String loginHospede) {
        this.contaAtual = new ContaAtual(loginHospede);
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (entregajornalCheckBox.isSelected()) {
            ServicoQuarto entregajornalServico = new ServicoQuarto("Entrega Jornal", entregajornal);
            contaAtual.adicionarServico(entregajornalServico);
            valorTotal += entregajornal;

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Entrega Jornal", entregajornal);
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (limpezaquartoCheckBox.isSelected()) {
            ServicoQuarto limpezaquartoServico = new ServicoQuarto("Limpeza de Quarto", limpezaquarto);
            contaAtual.adicionarServico(limpezaquartoServico);
            valorTotal += limpezaquarto;

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Limpeza de Quarto", limpezaquarto);
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (kithigieneCheckBox.isSelected()) {
            ServicoQuarto kithigieneServico = new ServicoQuarto("Kit Higiene", kithigiene);
            contaAtual.adicionarServico(kithigieneServico);
            valorTotal += kithigiene;

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Kit Higiene", kithigiene);
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }
        if (decoracaoespecialCheckBox.isSelected()) {
            ServicoQuarto decoracaoespecialServico = new ServicoQuarto("Decoração Especial", decoracaoespecial);
            contaAtual.adicionarServico(decoracaoespecialServico);
            valorTotal += decoracaoespecial;

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Decoração Especial", decoracaoespecial);
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        valorTotalLabel.setText("Valor Total: R$ " + String.format("%.2f", valorTotal));
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
