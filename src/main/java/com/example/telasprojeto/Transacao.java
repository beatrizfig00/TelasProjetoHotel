package com.example.telasprojeto;

public class Transacao {

    private String loginHospede;
    private String servico;
    private double preco;

    public Transacao(String loginHospede, String servico, double preco) {
        this.loginHospede = loginHospede;
        this.servico = servico;
        this.preco = preco;
    }
    @Override
    public String toString() {
        return transacaoParaString();
    }
    public String transacaoParaString() {
        return String.format("%s,%s,%.2f", loginHospede, servico, preco);
    }

    public static Transacao stringParaTransacao(String linha) {
        String[] partes = linha.split(",");
        String loginHospede = partes[0].trim();
        String servico = partes[1].trim();
        double preco = Double.parseDouble(partes[2].trim());

        return new Transacao(loginHospede, servico, preco);
    }
}
