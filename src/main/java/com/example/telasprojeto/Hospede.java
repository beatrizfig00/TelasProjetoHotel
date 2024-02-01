package com.example.telasprojeto;

public class Hospede {
    private String nome;
    private String sobrenome;
    private String endereco;
    private int idade;
    private String cpf;
    private String contato;
    private String email;
    private int id;
    private String login;
    private String senha;

    public Hospede() {
    }
    public Hospede(String nome, String sobrenome, String endereco, int idade, String cpf, String contato, String email, int id, String login, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.contato = contato;
        this.email = email;
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {

        this.login = login;
    }
    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }

    public String getSobrenome() {

        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {

        this.sobrenome = sobrenome;
    }

    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getIdade() {

        return idade;
    }

    public void setIdade(int idade) {

        this.idade = idade;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getContato() {

        return contato;
    }

    public void setContato(String contato) {

        this.contato = contato;
    }
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}