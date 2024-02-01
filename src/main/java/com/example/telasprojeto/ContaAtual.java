package com.example.telasprojeto;

import java.util.ArrayList;

public class ContaAtual {
    private ArrayList<Servico> servicosEscolhidos;
    private double total;
    private String loginHospede;


    public String getLoginHospede() {
        return loginHospede;
    }

    public ContaAtual(String loginHospede) {
        this.loginHospede = loginHospede;
        this.servicosEscolhidos = new ArrayList<>();
        this.total = 0.0;
    }
    public void adicionarServico(Servico servico) {
        servicosEscolhidos.add(servico);
        calcularTotal();
    }

    public void removerServico(Servico servico) {
        servicosEscolhidos.remove(servico);
        calcularTotal();
    }

    public void calcularTotal() {

        total = servicosEscolhidos.stream().mapToDouble(Servico::getPreco).sum();
    }

    public double getTotal() {

        return total;
    }

    public ArrayList<Servico> getServicosEscolhidos() {

        return servicosEscolhidos;
    }
    public void associarHospede(String loginHospede) {
        this.loginHospede = loginHospede;
    }

    public void adicionarTransacao(Transacao novaTransacao, String nomeArquivo) {
        ArquivoContaAtual.adicionarTransacao(novaTransacao, this.getLoginHospede(), nomeArquivo);
    }

    public ArrayList<Transacao> obterTransacoesDoHospede(String nomeArquivo) {
        return ArquivoContaAtual.obterTransacoesDoArquivo(nomeArquivo, this.getLoginHospede());
    }
}