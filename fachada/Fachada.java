package fachada;

import model.*;
import repository.AlunoRepository;
import service.TreinoService;

import java.util.List;
import java.util.NoSuchElementException;

public class Fachada {
    private static Fachada instance;

    private final AlunoRepository alunoRepository;
    private final TreinoService treinoService;

    private Fachada() {
        this.alunoRepository = AlunoRepository.getInstancia();
        this.treinoService = new TreinoService();
    }

    public static synchronized Fachada getInstancia() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunoRepository.adicionar(aluno);
    }

    public Aluno buscarAluno(String cpf) {
        Aluno aluno = alunoRepository.buscar(cpf);
        if (aluno == null) {
            throw new NoSuchElementException("Aluno com o CPF " + cpf + " não encontrado.");
        }
        return aluno;
    }

    public void removerAluno(String cpf) {
        alunoRepository.remover(cpf);
    }

    public List<Aluno> listarAlunos() {
        return List.copyOf(alunoRepository.listarTodos());
    }

    public Treino criarTreino(String nome, Instrutor instrutor, List<Exercicio> exercicios) {
        return treinoService.criarTreino(nome, instrutor, exercicios);
    }

    public void atribuirTreino(String cpfAluno, Treino treino) {
        Aluno aluno = this.buscarAluno(cpfAluno);
        treinoService.atribuirTreino(aluno, treino);
    }
}