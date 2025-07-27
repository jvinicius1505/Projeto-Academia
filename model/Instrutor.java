package model;

public class Instrutor extends Pessoa {
    private String especialidade;

    public Instrutor(String nome, String cpf, int idade, String especialidade) {
        super(nome, cpf, idade);
        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade não pode ser nula ou vazia.");
        }
        this.especialidade = especialidade;
    }

    public String getEspecialidade() { return especialidade; }
}