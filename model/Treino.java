package model;

import java.util.List;

public class Treino {
    private String nome;
    private Instrutor instrutor;
    private List<Exercicio> exercicios;

    public Treino(String nome, Instrutor instrutor, List<Exercicio> exercicios) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do treino não pode ser nulo ou vazio.");
        }
        if (instrutor == null) {
            throw new IllegalArgumentException("O instrutor não pode ser nulo.");
        }
        if (exercicios == null || exercicios.isEmpty()) {
            throw new IllegalArgumentException("A lista de exercícios não pode ser nula ou vazia.");
        }
        this.nome = nome;
        this.instrutor = instrutor;
        // Cria uma cópia imutável para proteger a lista interna de modificações externas
        this.exercicios = List.copyOf(exercicios);
    }

    public String getNome() { return nome; }
    public Instrutor getInstrutor() { return instrutor; }
    public List<Exercicio> getExercicios() { return exercicios; }
}