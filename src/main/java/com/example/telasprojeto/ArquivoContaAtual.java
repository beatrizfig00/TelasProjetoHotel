package com.example.telasprojeto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArquivoContaAtual {

    public static void salvarDadosEmArquivo(ArrayList<Transacao> lista, String nomeArquivo) {
        try {
            ArrayList<String> linhas = lista.stream().map(ArquivoContaAtual::transacaoParaString).collect(Collectors.toCollection(ArrayList::new));
            Path arquivo = Paths.get(nomeArquivo);
            Files.write(arquivo, linhas);
            System.out.println("Dados salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adicionarTransacao(Transacao transacao, String loginHospede, String nomeArquivo) {
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(transacao.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Transacao> obterTransacoesDoArquivo(String nomeArquivo, String loginHospede) {
        try {
            Path arquivo = Paths.get(nomeArquivo);
            System.out.println("Lendo arquivo: " + arquivo.toAbsolutePath());

            return Files.lines(arquivo)
                    .filter(linha -> linha.startsWith(loginHospede))
                    .map(ArquivoContaAtual::stringParaTransacao)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static String transacaoParaString(Transacao transacao) {
        // Implemente conforme a estrutura da sua classe Transacao
        // Aqui, estou assumindo que a classe Transacao tem um método
        // transacaoParaString() que converte a transação para uma string.
        return transacao.transacaoParaString();
    }

    public static Transacao stringParaTransacao(String linha) {
        // Implemente conforme a estrutura da sua classe Transacao
        // Aqui, estou assumindo que a classe Transacao tem um método
        // stringParaTransacao() que converte a string para uma transação.
        return Transacao.stringParaTransacao(linha);
    }
}
