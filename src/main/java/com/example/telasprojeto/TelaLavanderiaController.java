package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TelaLavanderiaController {

    @FXML
    private CheckBox lavagemNormalCheckBox;

    @FXML
    private CheckBox lavagemSecoCheckBox;

    @FXML
    private CheckBox passarRoupaCheckBox;

    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;
    private String loginHospede;

    private double lavagemNormal = 20.0;
    private double lavagemSeco = 30.0;
    private double passarRoupa = 10.0;

    @FXML
    public void initialize() {
        this.loginHospede = "biareg";
        this.contaAtual = new ContaAtual(loginHospede);
        System.out.println("Initialize chamado");

        lavagemNormalCheckBox.setOnAction(event -> calcularValorTotal());
        lavagemSecoCheckBox.setOnAction(event -> calcularValorTotal());
        passarRoupaCheckBox.setOnAction(event -> calcularValorTotal());
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (contaAtual != null) {
            if (lavagemNormalCheckBox.isSelected()) {
                Lavanderia lavagemNormalServico = new Lavanderia("Lavagem Normal", lavagemNormal);
                contaAtual.adicionarServico(lavagemNormalServico);
                valorTotal += lavagemNormalServico.getPreco();

                Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Lavagem Normal", lavagemNormalServico.getPreco());
                ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
            }

            if (lavagemSecoCheckBox.isSelected()) {
                Lavanderia lavagemSecoServico = new Lavanderia("Lavagem a Seco", lavagemSeco);
                contaAtual.adicionarServico(lavagemSecoServico);
                valorTotal += lavagemSecoServico.getPreco();

                Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Lavagem a Seco", lavagemSecoServico.getPreco());
                ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
            }

            if (passarRoupaCheckBox.isSelected()) {
                Lavanderia passarRoupaServico = new Lavanderia("Passar Roupa", passarRoupa);
                contaAtual.adicionarServico(passarRoupaServico);
                valorTotal += passarRoupaServico.getPreco();

                Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Passar Roupa", passarRoupaServico.getPreco());
                ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
            }
        }

        valorTotalLabel.setText("Valor Total: R$ " + String.format("%.2f", valorTotal));
    }
    @FXML
    private void adicionarAConta() {
        calcularValorTotal(); // Ou qualquer outra lógica necessária
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
