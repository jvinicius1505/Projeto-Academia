package service;

import model.*;
import java.util.List;

public class TreinoService {
    public Treino criarTreino(String nome, Instrutor instrutor, List<Exercicio> exercicios) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do treino não pode ser nulo ou vazio.");
        }
        if (instrutor == null) {
            throw new IllegalArgumentException("O instrutor não pode ser nulo.");
        }
        if (exercicios == null || exercicios.isEmpty()) {
            throw new IllegalArgumentException("A lista de exercícios não pode ser nula ou vazia.");
        }
        return new Treino(nome, instrutor, exercicios);
    }

    public void atribuirTreino(Aluno aluno, Treino treino) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        if (treino == null) {
            throw new IllegalArgumentException("Treino não pode ser nulo.");
        }
        aluno.adicionarTreino(treino);
    }
}