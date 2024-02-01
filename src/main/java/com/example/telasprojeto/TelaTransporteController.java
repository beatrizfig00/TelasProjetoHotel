package com.example.telasprojeto;

import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TelaTransporteController {

    @FXML
    private CheckBox taxiCheckBox;
    @FXML
    private CheckBox carroparticularCheckBox;
    @FXML
    private CheckBox limusineCheckBox;
    @FXML
    private Label valorTotalLabel;

    private ContaAtual contaAtual;

    private double taxi = 7.0;
    private double carroparticular = 5.0;
    private double limusine = 12.0;

    // Adicionei um parâmetro para o loginHospede no initialize
    @FXML
    private void initialize(String loginHospede) {
        this.contaAtual = new ContaAtual(loginHospede);
    }

    @FXML
    private void calcularValorTotal() {
        double valorTotal = 0.0;

        if (taxiCheckBox.isSelected()) {
            Transporte taxiServico = new Transporte("Taxi", taxi);
            contaAtual.adicionarServico(taxiServico);
            valorTotal += taxiServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Taxi", taxiServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (carroparticularCheckBox.isSelected()) {
            Transporte carroparticularServico = new Transporte("Carro Particular", carroparticular);
            contaAtual.adicionarServico(carroparticularServico);
            valorTotal += carroparticularServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Carro Particular", carroparticularServico.getPreco());
            ArquivoContaAtual.adicionarTransacao(transacao, contaAtual.getLoginHospede(), "ArquivoContaAtual.txt");
        }

        if (limusineCheckBox.isSelected()) {
            Transporte limusineServico = new Transporte("Limusine", limusine);
            contaAtual.adicionarServico(limusineServico);
            valorTotal += limusineServico.getPreco();

            Transacao transacao = new Transacao(contaAtual.getLoginHospede(), "Limusine", limusineServico.getPreco());
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
