package com.example.telasprojeto;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import java.io.IOException;
import java.time.LocalDate;

public class TelaPagamentoCartaoController {

    @FXML
    private Label valorTotalLabel;
    @FXML
    private TextField numeroCartaoTextField;
    @FXML
    private ToggleButton debitoToggleButton;
    @FXML
    private ToggleButton creditoToggleButton;
    @FXML
    private TextField numeroParcelasTextField; // Adicionado
    @FXML
    private Label mensagemPagamentoLabel;
    @FXML
    private Label valorParcelaLabel; // Adicionado
    private ContaAtual contaAtual;

    public TelaPagamentoCartaoController(String loginUsuario) {
        this.contaAtual = new ContaAtual(loginUsuario);
    }

    @FXML
    private void confirmarPagamento() {
        // Obter o valor total da conta da instância contaAtual
        double valorTotalConta = contaAtual.getTotal();

        // Obter o número do cartão dos TextFields
        String numeroCartao = numeroCartaoTextField.getText();

        // Obter o tipo do cartão com base no ToggleButton selecionado
        String tipoCartao = debitoToggleButton.isSelected() ? "Débito" : (creditoToggleButton.isSelected() ? "Crédito" : "");

        // Verificar se um tipo de cartão foi selecionado
        if (tipoCartao.isEmpty()) {
            mensagemPagamentoLabel.setText("Selecione o tipo do cartão!");
            return; // Saímos do método se nenhum tipo de cartão foi selecionado
        }

        // Inicializar o número de parcelas com 1 se não for crédito
        int numeroParcelas = tipoCartao.equalsIgnoreCase("Crédito") ? Integer.parseInt(numeroParcelasTextField.getText()) : 1;

        // Criar instância de PagamentoPorCartao
        PagamentoPorCartao pagamentoPorCartao = new PagamentoPorCartao(
                valorTotalConta,  // Usar o valor total da conta obtido da instância contaAtual
                LocalDate.now(),
                1,  // Substitua pelo identificador adequado
                numeroCartao,
                tipoCartao,
                numeroParcelas
        );

        // Realizar o pagamento
        pagamentoPorCartao.realizarPagamento();

        // Atualizar a interface gráfica com a mensagem de pagamento
        mensagemPagamentoLabel.setText("Pagamento realizado com sucesso!");

        // Exibir o valor da parcela se for crédito
        if (tipoCartao.equalsIgnoreCase("Crédito")) {
            double valorParcela = valorTotalConta / numeroParcelas;
            valorParcelaLabel.setText("Valor da Parcela: R$ " + valorParcela);
        } else {
            valorParcelaLabel.setText(""); // Limpar o texto se não for crédito
        }
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
