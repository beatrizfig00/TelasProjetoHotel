package com.example.telasprojeto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class TelaCadastroController {
    private String tipoUsuario;
    private ArrayList<Hospede> hospedes = new ArrayList<>();

    @FXML
    private Button voltarButton;
    @FXML
    private ComboBox<String> tipoUsuarioComboBox;
    @FXML
    public TextField nomeTextField;
    @FXML
    public TextField sobrenomeTextField;
    @FXML
    public TextField enderecoTextField;
    @FXML
    public TextField idadeTextField;
    @FXML
    public TextField telefoneTextField;
    @FXML
    public TextField cpfTextField;
    @FXML
    public TextField emailTextField;
    @FXML
    public TextField idTextField;
    @FXML
    public TextField loginTextField;
    @FXML
    public TextField senhaTextField;

    private HelloApplication helloApplication;

    public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
    }

    @FXML
    private void initialize() {
        tipoUsuarioComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            tipoUsuario = newValue;
            System.out.println("Tipo de Usuário selecionado: " + tipoUsuario);
        });
    }

    @FXML
    private void salvarDados() {
        System.out.println("Botão Salvar");

        if (tipoUsuario != null) {
            System.out.println("Tipo de Usuário selecionado: " + tipoUsuario);

            if (camposValidos()) {
                try {
                    int idade = Integer.parseInt(idadeTextField.getText());
                    int id = Integer.parseInt(idTextField.getText());

                    Hospede novoHospede = new Hospede(
                            nomeTextField.getText(),
                            sobrenomeTextField.getText(),
                            enderecoTextField.getText(),
                            idade,
                            cpfTextField.getText(),
                            telefoneTextField.getText(),
                            emailTextField.getText(),
                            id,
                            loginTextField.getText(),
                            senhaTextField.getText()
                    );

                    RepositorioHospede repositorio = new RepositorioHospede();
                    repositorio.cadastrarHospede(novoHospede);

                    ArquivoHospede.adicionarHospede(novoHospede, "hospedes.txt");

                } catch (NumberFormatException e) {
                    System.out.println("Erro: Certifique-se de que a idade e o ID sejam números válidos.");
                }
            } else {
                System.out.println("Preencha todos os campos corretamente.");
            }
        } else {
            System.out.println("Selecione um tipo de usuário.");
        }
    }

    private boolean camposValidos() {
        boolean camposValidos = !nomeTextField.getText().isEmpty() &&
                !sobrenomeTextField.getText().isEmpty() &&
                !enderecoTextField.getText().isEmpty() &&
                !idadeTextField.getText().isEmpty() &&
                !telefoneTextField.getText().isEmpty() &&
                !cpfTextField.getText().isEmpty() &&
                !emailTextField.getText().isEmpty() &&
                !idTextField.getText().isEmpty() &&
                !loginTextField.getText().isEmpty() &&
                !senhaTextField.getText().isEmpty();

        if (!camposValidos) {
            System.out.println("Campos inválidos:");
            if (nomeTextField.getText().isEmpty()) {
                System.out.println("Nome: [campo vazio]");
            }
            if (sobrenomeTextField.getText().isEmpty()) {
                System.out.println("Sobrenome: [campo vazio]");
            }
            if (enderecoTextField.getText().isEmpty()) {
                System.out.println("Endereço: [campo vazio]");
            }
            if (idadeTextField.getText().isEmpty()) {
                System.out.println("Idade: [campo vazio]");
            }
            if (telefoneTextField.getText().isEmpty()) {
                System.out.println("Telefone: [campo vazio]");
            }
            if (cpfTextField.getText().isEmpty()) {
                System.out.println("CPF: [campo vazio]");
            }
            if (emailTextField.getText().isEmpty()) {
                System.out.println("Email: [campo vazio]");
            }
            if (idTextField.getText().isEmpty()) {
                System.out.println("ID: [campo vazio]");
            }
            if (loginTextField.getText().isEmpty()) {
                System.out.println("Login: [campo vazio]");
            }
            if (senhaTextField.getText().isEmpty()) {
                System.out.println("Senha: [campo vazio]");
            }
        }

        return camposValidos;
    }

    @FXML
    public void voltarParaLogin() {
        try {
            HelloApplication.getInstance().carregarTela("tela-login.fxml", "Tela de Login", 620, 480);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limparCampos() {
        nomeTextField.clear();
        sobrenomeTextField.clear();
        enderecoTextField.clear();
        idadeTextField.clear();
        telefoneTextField.clear();
        cpfTextField.clear();
        emailTextField.clear();
        idTextField.clear();
        loginTextField.clear();
        senhaTextField.clear();
        tipoUsuarioComboBox.getSelectionModel().clearSelection();
    }
}
