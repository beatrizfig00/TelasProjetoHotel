package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TelaSpaController {

    @FXML
    private CheckBox acupunturaCheckBox;
    @FXML
    private CheckBox massagemCheckBox;
    @FXML
    private CheckBox limpezaDePeleCheckBox;
    @FXML
    private CheckBox spaDosPesCheckBox;
    @FXML
    private CheckBox saunaCheckBox;
    @FXML
    private CheckBox hidromassagemCheckBox;
    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;

    private double acupuntura = 150.0;
    private double massagem = 90.0;
    private double limpezaDePele = 110.0;
    private double spaDosPes = 50.0;
    private double sauna = 20.0;
    private double hidromassagem = 30.0;

    // Adicionei um parâmetro para o loginHospede no initialize
    @FXML
    private void initialize(String loginHospede) {
        this.contaAtual = new ContaAtual(loginHospede);
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (acupunturaCheckBox.isSelected()) {
            Spa acupunturaServico = new Spa("Acupuntura", acupuntura);
            contaAtual.adicionarServico(acupunturaServico);
            valorTotal += acupunturaServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Acupuntura", acupunturaServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (massagemCheckBox.isSelected()) {
            Spa massagemServico = new Spa("Massagem", massagem);
            contaAtual.adicionarServico(massagemServico);
            valorTotal += massagemServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Massagem", massagemServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (limpezaDePeleCheckBox.isSelected()) {
            Spa limpezaDePeleServico = new Spa("Limpeza de Pele", limpezaDePele);
            contaAtual.adicionarServico(limpezaDePeleServico);
            valorTotal += limpezaDePeleServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Limpeza de Pele", limpezaDePeleServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (spaDosPesCheckBox.isSelected()) {
            Spa spaDosPesServico = new Spa("Spa dos Pés", spaDosPes);
            contaAtual.adicionarServico(spaDosPesServico);
            valorTotal += spaDosPesServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Spa dos Pés", spaDosPesServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (saunaCheckBox.isSelected()) {
            Spa saunaServico = new Spa("Sauna", sauna);
            contaAtual.adicionarServico(saunaServico);
            valorTotal += saunaServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Sauna", saunaServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (hidromassagemCheckBox.isSelected()) {
            Spa hidromassagemServico = new Spa("Hidromassagem", hidromassagem);
            contaAtual.adicionarServico(hidromassagemServico);
            valorTotal += hidromassagemServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Hidromassagem", hidromassagemServico.getPreco());
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
