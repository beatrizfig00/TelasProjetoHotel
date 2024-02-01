package com.example.telasprojeto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Platform;

public class TelaPagamentoDinheiroController {
    @FXML
    private Label valorTotalLabel;

    @FXML
    private TextField valorPagoTextField;
    private ContaAtual contaAtual;
    @FXML
    private Label trocoLabel;

    public TelaPagamentoDinheiroController(String loginUsuario) {
        this.contaAtual = new ContaAtual(loginUsuario);
    }

    @FXML
    private void confirmarPagamento() {
        // Obter o valor pago do TextField
        double valorPago = Double.parseDouble(valorPagoTextField.getText());

        // Obter o valor total da conta da instância contaAtual
        double valorTotalConta = contaAtual.getTotal();

        // Criar instância de PagamentoPorDinheiro
        PagamentoPorDinheiro pagamentoPorDinheiro = new PagamentoPorDinheiro(
                valorTotalConta,  // Usar o valor total da conta obtido da instância contaAtual
                LocalDate.now(),
                1,  // Substitua pelo identificador adequado
                valorPago,  // Valor pago
                0.0  // O troco será calculado no método realizarPagamento
        );

        // Realizar o pagamento
        pagamentoPorDinheiro.realizarPagamento();

        // Atualizar a interface gráfica com o troco
        trocoLabel.setText("Troco: R$ " + pagamentoPorDinheiro.getTroco());
    }

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
}
