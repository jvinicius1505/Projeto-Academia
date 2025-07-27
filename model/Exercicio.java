package model;

public class Exercicio {
    private String nome;
    private String grupoMuscular;

    public Exercicio(String nome, String grupoMuscular) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do exercício não pode ser nulo ou vazio.");
        }
        if (grupoMuscular == null || grupoMuscular.trim().isEmpty()) {
            throw new IllegalArgumentException("Grupo muscular não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
    }

    public String getNome() { return nome; }
    public String getGrupoMuscular() { return grupoMuscular; }
}