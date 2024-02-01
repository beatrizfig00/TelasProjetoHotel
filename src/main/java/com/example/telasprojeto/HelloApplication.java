package com.example.telasprojeto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static HelloApplication instance;
    private static Stage primaryStage;
    private Stage cadastroStage;
    private RepositorioHospede repositorio;
    private ContaAtual contaAtual;

    public static HelloApplication getInstance() {
        return instance;
    }

    public RepositorioHospede getRepositorio() {
        return repositorio;
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        instance = this;
        this.primaryStage = primaryStage;

        Image icon = new Image(getClass().getResourceAsStream("/icone.png"));
        primaryStage.getIcons().add(icon);

        // Carrega os dados do arquivo para o RepositorioHospede
        repositorio = new RepositorioHospede();
        ArrayList<Hospede> hospedesDoArquivo = ArquivoHospede.obterHospedesDoArquivo("hospedes.txt");

        // Itera sobre a lista de hospedesDoArquivo e cadastra cada hospede no RepositorioHospede
        for (Hospede hospede : hospedesDoArquivo) {
            repositorio.cadastrarHospede(hospede);
        }
        String loginUsuario = "nomeDoUsuario";
        ContaAtual contaAtual = new ContaAtual(loginUsuario);
        instance.setContaAtual(contaAtual);

        telaLogin();
    }
    public void setContaAtual(ContaAtual contaAtual) {
        this.contaAtual = contaAtual;
    }
    public void telaLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela-login.fxml"));
        Parent root = fxmlLoader.load();
        TelaLoginController telaLoginController = fxmlLoader.getController();

        telaLoginController.setHelloApplication(this);

        Scene scene = new Scene(root, 620, 480);
        primaryStage.setTitle("Tela de Login");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        cadastroStage = new Stage();
        FXMLLoader cadastroLoader = new FXMLLoader(getClass().getResource("tela-cadastro.fxml"));
        Parent cadastroRoot = cadastroLoader.load();
        TelaCadastroController telaCadastroController = cadastroLoader.getController();
        telaCadastroController.setHelloApplication(this);

        Scene cadastroScene = new Scene(cadastroRoot, 1300, 800);
        cadastroStage.setTitle("Tela de Cadastro");
        cadastroStage.setScene(cadastroScene);
        // fecha a tela de cadastro quando a tela de login for fechada
        primaryStage.setOnHidden(event -> cadastroStage.close());
    }

    public void carregarTela(String fxmlPath, String title, int width, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, width, height);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void TelaPrincipalHospede() throws IOException {
        System.out.println("Entrando em TelaPrincipalHospede()");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela-principal.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setTitle("Tela Principal do Hospede");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void TelaPrincipalAdm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela-adm-principal.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setTitle("Tela Principal do Administrador");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
