package com.example.telasprojeto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Alert;


public class TelaLoginController {

    @FXML
    private Button cadastroButton;
    @FXML
    private ComboBox<String> tipoUsuarioComboBox;
    @FXML
    private HelloApplication helloApplication;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField senhaPasswordField;
    @FXML
    private Button entrarButton;
    private boolean loginValido = false;


    private RepositorioHospede repositorio;

       public void setHelloApplication(HelloApplication helloApplication) {
        this.helloApplication = helloApplication;
        this.repositorio = helloApplication.getRepositorio(); // Inicializa o RepositorioHospede
    }

    @FXML
    private void CadastroButton() {
        try {
            helloApplication.carregarTela("tela-cadastro.fxml", "Tela de Cadastro", 1300, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void EntrarButton() {
        if (this.repositorio == null) {
            setHelloApplication(helloApplication);
        }
        if (helloApplication == null) {
            return;
        }
        String login = loginTextField.getText();
        String senha = senhaPasswordField.getText();
        String tipoUsuarioSelecionado = tipoUsuarioComboBox.getValue();


        if (tipoUsuarioSelecionado != null) {
            ArrayList<Hospede> hospedes = repositorio.getAllHospedes();

            boolean loginValido = false;

            for (Hospede hospede : hospedes) {

                if (hospede.getLogin().equals(login) && hospede.getSenha().equals(senha)) {
                    loginValido = true;
                    break;
                }
            }
            if (loginValido) {

                try {
                    if ("Administrador".equals(tipoUsuarioSelecionado)) {
                        helloApplication.TelaPrincipalAdm();
                    } else if ("Hospede".equals(tipoUsuarioSelecionado)) {
                        helloApplication.TelaPrincipalHospede();
                    } else {
                        System.out.println("Tipo de usuário inválido.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Login inválido.");
            }
        } else {
            System.out.println("Tipo de Usuário é nulo.");
        }
    }

    @FXML
    private void SairButton() {
        Platform.exit();
        System.exit(0);
    }
}
