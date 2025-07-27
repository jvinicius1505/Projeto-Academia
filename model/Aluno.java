package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa implements UsuarioSistema {
    private String plano;
    private List<Treino> treinos = new ArrayList<>();

    public Aluno(String nome, String cpf, int idade, String plano) {
        super(nome, cpf, idade);
        if (plano == null || plano.trim().isEmpty()) {
            throw new IllegalArgumentException("Plano não pode ser nulo ou vazio.");
        }
        this.plano = plano;
    }

    public String getPlano() { return plano; }
    public List<Treino> getTreinos() { return treinos; }

    public void adicionarTreino(Treino treino) {
        if (treino != null) {
            treinos.add(treino);
        }
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }
}