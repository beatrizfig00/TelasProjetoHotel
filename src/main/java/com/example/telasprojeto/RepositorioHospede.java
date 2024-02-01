package com.example.telasprojeto;

import java.util.ArrayList;

public class RepositorioHospede {
    private ArrayList<Hospede> hospedes;

    public RepositorioHospede() {
        this.hospedes = new ArrayList<>();
    }

    public void cadastrarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public ArrayList<Hospede> getAllHospedes() {
        return hospedes;
    }

    public void removerHospede(int id) {
        hospedes.removeIf(hospede -> hospede.getId() == id);
    }

    public Hospede getHospedePorLoginSenha(String login, String senha) {
        for (Hospede hospede : hospedes) {
            if (hospede.getLogin().equals(login) && hospede.getSenha().equals(senha)) {
                return hospede;
            }
        }
        return null;
    }
}
